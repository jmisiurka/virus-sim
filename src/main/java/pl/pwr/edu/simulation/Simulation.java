package pl.pwr.edu.simulation;

import pl.pwr.edu.map.CellState;
import pl.pwr.edu.map.Map;
import pl.pwr.edu.population.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    List<SimulationState> states = new ArrayList<>();
    SimulationState currentState;
    SimulationParameters parameters;
    Random rand = new Random();

    Simulation(SimulationParameters params, SimulationState initialState)
    {
        this.parameters = params;

        currentState = initialState;
        currentState.map = new Map(parameters.getMapSize());
    }

    public List<SimulationState> runSimulation()
    {
        while (checkSimulation())
        {
            simulationStep();
            currentState = new SimulationState(currentState.people, currentState.map);
        }
        return states;
    }

    private void simulationStep()
    {
        updatePeople();
        updateMap();
        currentState.map.printMap();
        states.add(currentState);
    }

    private void updatePeople() {
        List<Person> tempPeople = new ArrayList<>();
        for (Person person : currentState.people)
        {
            if (person.getImmunity() > 0.9f) {
                person.setImmunity(person.getImmunity() - .02f);
            }

            if (person.isInfected() && person.getHealthiness() < rand.nextFloat())
            {
                person.setAlive(false);
            } else if (person.isInfected() && person.getHealthiness() > rand.nextFloat() + 0.9)
            {
                person.recoverFromSickness();
            }

            person.move(parameters.getMapSize());

            if (person.isAlive())
            {
                tempPeople.add(person);
            }

            for (Person otherPerson : currentState.people)
            {
                if (otherPerson.getPosition().getDistance(person.getPosition()) < 2.f)
                {
                    person.spreadVirus(otherPerson);
                }
            }
        }
        currentState.people = tempPeople;
    }

    private boolean checkSimulation()
    {
        return !currentState.people.isEmpty() && currentState.people.stream().anyMatch(Person::isInfected);
    }

    private void updateMap()
    {
        currentState.map.clearMap();

        for (Person person : currentState.people)
        {
            if (person.isInfected()) {
                currentState.map.setCellState(person.getPosition(), CellState.INFECTED_PERSON);
            } else {
                currentState.map.setCellState(person.getPosition(), CellState.HEALTHY_PERSON);
            }
        }
    }
}
