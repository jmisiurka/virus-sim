package pl.pwr.edu.simulation;

import pl.pwr.edu.io.CsvWriter;
import pl.pwr.edu.population.PersonCreator;
import pl.pwr.edu.io.ArgumentParser;
import pl.pwr.edu.population.PersonParameters;

import java.util.List;

public class Application {
    static private final ArgumentParser argumentParser = new ArgumentParser();
    static private final CsvWriter csvWriter = new CsvWriter();
    static private final PersonCreator personCreator = new PersonCreator();

    public static void main(String[] args) {
        SimulationParameters params = argumentParser.parseArguments(args);
        try {
            personCreator.setPersonParameters(argumentParser.parsePersonParameters("src/main/resources/personParameters.json"));
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        SimulationState initialState = SimulationCreator.createSimulation(params, personCreator);
        Simulation simulation = new Simulation(params, initialState);

        List<SimulationState> outputStates = simulation.runSimulation();
        csvWriter.saveStates(outputStates);
    }
}
