package pwr.edu.simulation;

import pwr.edu.map.Map;
import pwr.edu.population.Person;
import pwr.edu.population.PersonCreator;
import pwr.edu.virus.Virus;

import java.util.ArrayList;
import java.util.List;

public class SimulationCreator {
    public static SimulationState createSimulation(SimulationParameters parameters) {
        List<Person> people = new ArrayList<>();
        PersonCreator personCreator = new PersonCreator();

        for (int i = 0; i < parameters.getMapSize() * parameters.getMapSize() * parameters.getPopulationDensity(); i++)
        {
            people.add(personCreator.createPerson(parameters.getMapSize()));
        }

        people.get(0).createFirstVirus(new Virus(parameters.getVirusMutability(),
                parameters.getStartingVirusInfectivity(), parameters.getStartingVirusDeadliness()));

        SimulationState state = new SimulationState(people, new Map(parameters.getMapSize()));

        return state;
    }
}
