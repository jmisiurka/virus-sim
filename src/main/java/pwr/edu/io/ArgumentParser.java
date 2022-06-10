package pwr.edu.io;

import com.google.gson.stream.JsonReader;
import pwr.edu.population.PersonParameters;
import pwr.edu.simulation.SimulationParameters;

import java.io.FileReader;
import java.io.IOException;

public class ArgumentParser {
    public SimulationParameters parseArguments(String[] args)
    {
        int mapSize = Integer.parseInt(args[0]);
        float populationDensity = Float.parseFloat(args[1]);
        float virusMutability = Float.parseFloat(args[2]);
        float startingVirusInfectivity = Float.parseFloat(args[3]);
        float startingVirusDeadliness = Float.parseFloat(args[4]);

        return new SimulationParameters(mapSize, populationDensity, virusMutability,
                startingVirusInfectivity, startingVirusDeadliness);
    }

    public PersonParameters parsePersonParameters(String confFilePath) throws IOException {
        float minimumHealthiness = 0;
        float minimumImmunity = 0;
        float minimumActiveness = 0;
        float maximumHealthiness = 0;
        float maximumImmunity = 0;
        float maximumActiveness = 0;
        JsonReader reader = new JsonReader(new FileReader(confFilePath));
        reader.beginObject();

        while (reader.hasNext())
        {
            String parameter = reader.nextName();
            switch (parameter) {
                case "minimumHealthiness":
                    minimumHealthiness = (float) reader.nextDouble();
                    break;
                case "minimumImmunity":
                    minimumImmunity = (float) reader.nextDouble();
                    break;
                case "minimumActiveness":
                    minimumActiveness = (float) reader.nextDouble();
                    break;
                case "maximumHealthiness":
                    maximumHealthiness = (float) reader.nextDouble();
                    break;
                case "maximumImmunity":
                    maximumImmunity = (float) reader.nextDouble();
                    break;
                case "maximumActiveness":
                    maximumActiveness = (float) reader.nextDouble();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }

        reader.endObject();

        return new PersonParameters(minimumHealthiness, minimumImmunity, minimumActiveness,
                maximumHealthiness, maximumImmunity, maximumActiveness);
    }
}
