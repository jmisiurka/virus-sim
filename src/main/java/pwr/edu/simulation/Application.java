package pwr.edu.simulation;

import pwr.edu.io.ArgumentParser;
import pwr.edu.io.CsvWriter;
import pwr.edu.population.Person;

public class Application {
    static private ArgumentParser argumentParser = new ArgumentParser();
    static private CsvWriter csvWriter = new CsvWriter();

    public static void main(String[] args) {
        SimulationParameters params = argumentParser.parseArguments(args);
        Simulation simulation = new Simulation(params);
        try {
            Person.setPersonParameters(argumentParser.parsePersonParameters("src/resources/personParameters.json"));
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        simulation.runSimulation();
    }
}
