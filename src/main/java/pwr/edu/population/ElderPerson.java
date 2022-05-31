package pwr.edu.population;

import java.util.Random;

public class ElderPerson extends Person {
    private static float minimumHealthiness = 0.85f;
    private static float minimumImmunity = 0.1f;
    private static float minimumActiveness = 0.0f;
    private static float maximumHealthiness = 0.99f;
    private static float maximumImmunity = 0.7f;
    private static float maximumActiveness = 1.0f;

    static Random rand = new Random();

    public ElderPerson(int mapSize)
    {
        super(mapSize);
        //this.healthiness = minimumHealthiness + rand.nextFloat() * (maximumHealthiness - minimumHealthiness);
        //this.immunity = minimumImmunity + rand.nextFloat() * (maximumImmunity - minimumImmunity);
        //this.activeness = minimumActiveness + rand.nextFloat() * (maximumActiveness - minimumActiveness);
    }
}
