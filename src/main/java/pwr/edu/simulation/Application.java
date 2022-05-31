package pwr.edu.simulation;

import pwr.edu.io.ArgumentParser;
import pwr.edu.io.CsvWriter;

public class Application {
    static private ArgumentParser argumentParser = new ArgumentParser();
    static private CsvWriter csvWriter = new CsvWriter();

    public static void main(String[] args) {
        SimulationParameters params = argumentParser.parseArguments(args);
        Simulation simulation = new Simulation(params);

        simulation.runSimulation();
    }
}
