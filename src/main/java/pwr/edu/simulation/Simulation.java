package pwr.edu.simulation;

import pwr.edu.map.CellState;
import pwr.edu.map.Map;
import pwr.edu.population.Person;
import pwr.edu.population.PersonCreator;
import pwr.edu.virus.Virus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    List<SimulationState> states = new ArrayList<>();
    SimulationState currentState;
    SimulationParameters parameters;
    PersonCreator personCreator;
    Random rand = new Random();

    Simulation(SimulationParameters params, SimulationState initialState)
    {
        this.parameters = params;

        currentState = initialState;
        currentState.map = new Map(parameters.getMapSize());
    }

    public void runSimulation()
    {
        while (checkSimulation())
        {
            simulationStep();
            currentState = new SimulationState(currentState.people, currentState.map);
        }
    }

    private void simulationStep()
    {
        updatePeople();
        updateMap();
        currentState.map.printMap();
        states.add(currentState);
    }

    private void updatePeople() {
        List<Person> tempPeople = new ArrayList<Person>();
        for (Person person : currentState.people)
        {
            if (person.getImmunity() > 0.9f) {
                person.setImmunity(person.getImmunity() - .02f);
            }

            if (person.getHealthiness() < rand.nextFloat())
            {
                person.setAlive(false);
            } else if (person.getHealthiness() > rand.nextFloat() + 0.9)
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
                if (Math.abs(person.getPosition().x - otherPerson.getPosition().x) <= 1 &&
                        Math.abs(person.getPosition().y - otherPerson.getPosition().y) <= 1)
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
