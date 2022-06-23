package pl.pwr.edu.simulation;

import pl.pwr.edu.population.Person;
import pl.pwr.edu.population.PersonCreator;
import pl.pwr.edu.map.Map;
import pl.pwr.edu.virus.Virus;

import java.util.ArrayList;
import java.util.List;

public class SimulationCreator {
    public static SimulationState createSimulation(SimulationParameters parameters, PersonCreator personCreator) {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < parameters.getMapSize() * parameters.getMapSize() * parameters.getPopulationDensity(); i++)
        {
            people.add(personCreator.createPerson(parameters.getMapSize()));
        }

        people.get(0).createFirstVirus(new Virus(parameters.getVirusMutability(),
                parameters.getStartingVirusInfectivity(), parameters.getStartingVirusDeadliness()));

        return new SimulationState(people, new Map(parameters.getMapSize()));
    }
}
