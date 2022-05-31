package pwr.edu.simulation;

public class SimulationParameters {
    public SimulationParameters(int elderPercentage, int mapSize, float populationDensity,
                                float virusMutability, float startingVirusInfectivity, float startingVirusDeadliness) {
        this.elderPercentage = elderPercentage; //0-100
        this.mapSize = mapSize;
        this.populationDensity = populationDensity; // people/9 squares
        this.virusMutability = virusMutability;
        this.startingVirusInfectivity = startingVirusInfectivity;
        this.startingVirusDeadliness = startingVirusDeadliness;
    }

    private int elderPercentage;
    private int mapSize;
    private float populationDensity;
    private float virusMutability;
    private float startingVirusInfectivity;
    private float startingVirusDeadliness;

    public int getElderPercentage() {
        return elderPercentage;
    }

    public int getMapSize() {
        return mapSize;
    }

    public float getPopulationDensity() {
        return populationDensity;
    }

    public float getVirusMutability() {
        return virusMutability;
    }

    public float getStartingVirusInfectivity() {
        return startingVirusInfectivity;
    }

    public float getStartingVirusDeadliness() {
        return startingVirusDeadliness;
    }
}
