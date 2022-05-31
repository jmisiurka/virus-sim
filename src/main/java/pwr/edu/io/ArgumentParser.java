package pwr.edu.io;

import pwr.edu.simulation.SimulationParameters;

public class ArgumentParser {
    public SimulationParameters parseArguments(String[] args)
    {
        int elderPercentage = Integer.parseInt(args[0]);
        int mapSize = Integer.parseInt(args[1]);
        float populationDensity = Float.parseFloat(args[2]);
        float virusMutability = Float.parseFloat(args[3]);
        float startingVirusInfectivity = Float.parseFloat(args[4]);
        float startingVirusDeadliness = Float.parseFloat(args[5]);

        return new SimulationParameters(elderPercentage, mapSize, populationDensity, virusMutability,
                startingVirusInfectivity, startingVirusDeadliness);
    }
}
