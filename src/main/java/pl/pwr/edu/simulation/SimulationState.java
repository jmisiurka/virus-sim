package pl.pwr.edu.simulation;

import pl.pwr.edu.map.Map;
import pl.pwr.edu.population.Person;

import java.util.ArrayList;
import java.util.List;

public class SimulationState {
    List<Person> people;
    private final int healthyPeople;
    private final int infectedPeople;
    Map map;

    public SimulationState(List<Person> people, Map map) {
        this.people = people;
        this.map = map;
        infectedPeople = countInfected();
        healthyPeople = people.size() - infectedPeople;
    }

    public int getHealthyPeople() {
        return healthyPeople;
    }

    public int getInfectedPeople() {
        return infectedPeople;
    }

    private int countInfected() {
        int counter = 0;
        for (Person person : people)
        {
            if (person.isInfected())
            {
                counter++;
            }
        }
        return counter;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
