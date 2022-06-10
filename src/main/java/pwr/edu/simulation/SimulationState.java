package pwr.edu.simulation;

import pwr.edu.map.Map;
import pwr.edu.population.Person;

import java.util.ArrayList;
import java.util.List;

public class SimulationState {
    List<Person> people = new ArrayList<Person>();
    private int healthyPeople;
    private int infectedPeople;
    Map map;

    public SimulationState(List<Person> people) {
        this.people = people;
    }

    public int getHealthyPeople() {
        return healthyPeople;
    }

    public void setHealthyPeople(int healthyPeople) {
        this.healthyPeople = healthyPeople;
    }

    public int getInfectedPeople() {
        return infectedPeople;
    }

    public void setInfectedPeople(int infectedPeople) {
        this.infectedPeople = infectedPeople;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
