package pwr.edu.simulation;

import pwr.edu.population.Person;
import pwr.edu.virus.Virus;

import java.util.Random;
import java.util.Vector;

public class Simulation {
    SimulationParameters parameters;
    Random rand = new Random();
    Vector<Person> people = new Vector<Person>();
    char map[][];
    Simulation(SimulationParameters params)
    {
        this.parameters = params;
        for (int i = 0; i < params.getMapSize() * parameters.getPopulationDensity(); i++)
        {
            people.add(new Person(parameters.getMapSize()));
        }

        people.elementAt(0).createFirstVirus(new Virus(parameters.getVirusMutability(),
                parameters.getStartingVirusInfectivity(), parameters.getStartingVirusDeadliness()));

        map = new char[parameters.getMapSize()][parameters.getMapSize()];

        for (char[] row : map)
        {
            for (char cell : row)
            {
                cell = ' ';
            }
        }
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
        printMap();
    }

    private void updatePeople() {
        Vector<Person> tempPeople = new Vector<Person>();
        for (Person person : people)
        {
            if (!person.update(parameters))
            {
                continue;
            } else {
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
        for (int row = 0; row < map.length; row++)
        {
            for (int column = 0; column < map[row].length; column++)
            {
                map[row][column] = ' ';
            }
        }
        for (Person person : people)
        {
            if (person.isInfected()) {
                map[person.getPosition().y][person.getPosition().x] = 'x';
            } else {
                map[person.getPosition().y][person.getPosition().x] = 'o';
            }
        }
    }

    private void printMap()
    {
        for (int row = 0; row < map.length; row++)
        {
            for (int column = 0; column < map[row].length; column++)
            {
                System.out.print(map[row][column]);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }
}
