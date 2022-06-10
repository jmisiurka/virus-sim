package pwr.edu.simulation;

import pwr.edu.io.ArgumentParser;
import pwr.edu.io.CsvWriter;
import pwr.edu.population.Person;
import pwr.edu.population.PersonCreator;

public class Application {
    static private ArgumentParser argumentParser = new ArgumentParser();
    static private CsvWriter csvWriter = new CsvWriter();

    public static void main(String[] args) {
        SimulationParameters params = argumentParser.parseArguments(args);
        try {
            PersonCreator.setPersonParameters(argumentParser.parsePersonParameters("src/main/resources/personParameters.json"));
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        SimulationState initialState = SimulationCreator.createSimulation(params);
        Simulation simulation = new Simulation(params, initialState);

        simulation.runSimulation();
    }
}
