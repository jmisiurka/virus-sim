package pl.pwr.edu.io;

import pl.pwr.edu.simulation.SimulationState;

import java.io.FileWriter;
import java.util.List;

public class CsvWriter {
    public void saveStates(List<SimulationState> states) {
        try {
            FileWriter fileWriter = new FileWriter("output.csv");

            fileWriter.write("total;healthy;infected;infected percentage\n");

            for (SimulationState state : states)
            {
                float percentage = 100.0f * (float) state.getInfectedPeople() / (state.getHealthyPeople() + state.getInfectedPeople());
                String stateOutputString = String.format("%d;%d;%d;%.2f\n", state.getHealthyPeople() + state.getInfectedPeople(),
                        state.getHealthyPeople(), state.getInfectedPeople(), percentage);
                fileWriter.write(stateOutputString);
            }

            fileWriter.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
