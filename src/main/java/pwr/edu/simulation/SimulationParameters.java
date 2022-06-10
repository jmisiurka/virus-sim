package pwr.edu.simulation;

public class SimulationParameters {
    public SimulationParameters(int mapSize, float populationDensity,
                                float virusMutability, float startingVirusInfectivity, float startingVirusDeadliness) {
        this.mapSize = mapSize;
        this.populationDensity = populationDensity; // people/9 squares
        this.virusMutability = virusMutability;
        this.startingVirusInfectivity = startingVirusInfectivity;
        this.startingVirusDeadliness = startingVirusDeadliness;
    }

    private final int mapSize;
    private final float populationDensity;
    private final float virusMutability;
    private final float startingVirusInfectivity;
    private final float startingVirusDeadliness;

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
