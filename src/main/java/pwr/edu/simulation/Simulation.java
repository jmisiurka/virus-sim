package pwr.edu.simulation;

import pwr.edu.map.CellState;
import pwr.edu.map.Map;
import pwr.edu.population.Person;
import pwr.edu.virus.Virus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    List<SimulationState> states;
    SimulationState currentState;
    SimulationParameters parameters;
    Random rand = new Random();

    Simulation(SimulationParameters params)
    {
        this.parameters = params;
        for (int i = 0; i < params.getMapSize() * parameters.getPopulationDensity(); i++)
        {
            currentState.people.add(new Person(parameters.getMapSize()));
        }

        currentState.people.get(0).createFirstVirus(new Virus(parameters.getVirusMutability(),
                parameters.getStartingVirusInfectivity(), parameters.getStartingVirusDeadliness()));

        currentState.map = new Map(params.getMapSize());
    }

    public void runSimulation()
    {
        while (checkSimulation())
        {
            simulationStep();
        }
    }

    private void simulationStep()
    {
        updatePeople();
        updateMap();
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
