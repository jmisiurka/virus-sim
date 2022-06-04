package pwr.edu.simulation;

import pwr.edu.map.CellState;
import pwr.edu.map.Map;
import pwr.edu.population.Person;
import pwr.edu.virus.Virus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    SimulationParameters parameters;
    Random rand = new Random();
    List<Person> people = new ArrayList<Person>();
    Map map;
    Simulation(SimulationParameters params)
    {
        this.parameters = params;
        for (int i = 0; i < params.getMapSize() * parameters.getPopulationDensity(); i++)
        {
            people.add(new Person(parameters.getMapSize()));
        }

        people.get(0).createFirstVirus(new Virus(parameters.getVirusMutability(),
                parameters.getStartingVirusInfectivity(), parameters.getStartingVirusDeadliness()));

        map = new Map(params.getMapSize());
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
        for (Person person : people)
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

            for (Person otherPerson : people)
            {
                if (Math.abs(person.getPosition().x - otherPerson.getPosition().x) <= 1 &&
                        Math.abs(person.getPosition().y - otherPerson.getPosition().y) <= 1)
                {
                    person.spreadVirus(otherPerson);
                }
            }
        }
        people = tempPeople;
    }

    private boolean checkSimulation()
    {
        boolean virusExists = false;
        if (people.isEmpty())
        {
            return false;
        }
        for (Person person : people)
        {
            if (person.isInfected())
            {
                return true;
            }
        }
        return false;
    }

    private void updateMap()
    {
        map.clearMap();

        for (Person person : people)
        {
            if (person.isInfected()) {
                map.setCellState(person.getPosition(), CellState.INFECTED_PERSON);
            } else {
                map.setCellState(person.getPosition(), CellState.HEALTHY_PERSON);
            }
        }
    }
}
