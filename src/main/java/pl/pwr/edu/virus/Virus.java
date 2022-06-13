package pl.pwr.edu.virus;

import java.util.Random;

public class Virus {
    private float mutability;
    private float infectivity;
    private float deadliness;
    private static final Random rand = new Random();

    public Virus(float mutability, float infectivity, float deadliness)
    {
        this.mutability = mutability;
        this.infectivity = infectivity;
        this.deadliness = deadliness;
    }

    public Virus(Virus virus) {
        this.mutate();
    }

    private void mutate() {
        infectivity += mutability * (2 * rand.nextFloat() - 1);
        deadliness += mutability * (2 * rand.nextFloat() - 1);
    }
}
