package pwr.edu.population;

import pwr.edu.simulation.SimulationParameters;
import pwr.edu.virus.Virus;

import java.awt.*;
import java.util.Random;

public class Person {
    private static float minimumHealthiness = 0.95f;
    private static float minimumImmunity = 0.3f;
    private static float minimumActiveness = 0.2f;
    private static float maximumHealthiness = 0.99f;
    private static float maximumImmunity = 0.8f;
    private static float maximumActiveness = 1.0f;

    static Random rand = new Random();
    protected Point position = new Point();
    protected float healthiness;
    protected float immunity;
    protected float activeness;
    private Virus virus;

    public Person(int mapSize) {
        this.healthiness = minimumHealthiness + rand.nextFloat() * (maximumHealthiness - minimumHealthiness);
        this.immunity = minimumImmunity + rand.nextFloat() * (maximumImmunity - minimumImmunity);
        this.activeness = minimumActiveness + rand.nextFloat() * (maximumActiveness - minimumActiveness);
        position.x = rand.nextInt(mapSize);
        position.y = rand.nextInt(mapSize);
    }

    public boolean update(SimulationParameters params) {
        if (this.immunity > 0.9f) {
            this.immunity -= 0.02f;
        }

        if (this.healthiness < rand.nextFloat())
        {
            die();
            return false;
        } else if (this.healthiness > rand.nextFloat() + 0.9)
        {
            recoverFromSickness();
        }

        position = move(params.getMapSize());
        return true;
    }

    private void die() {
        virus = null;
    }

    protected Point move(int mapSize) {
        if (activeness < rand.nextFloat())
        {
            return position;
        }
        boolean moved = false;
        while (!moved) {
            int direction = rand.nextInt(5);
            switch (direction) {
                case 1:
                    if (position.x < mapSize - 1) {
                        position.x++;
                        moved = true;
                    }
                    break;
                case 2:
                    if (position.y < mapSize - 1) {
                        position.y++;
                        moved = true;
                    }
                    break;
                case 3:
                    if (position.x > 0) {
                        position.x--;
                        moved = true;
                    }
                    break;
                case 4:
                    if (position.y > 0) {
                        position.y--;
                        moved = true;
                    }
                    break;
                default:
                    break;
            }
        }
        return position;
    }

    public void spreadVirus(Person person) {
        if (this.isInfected() && person.getImmunity() < new Random().nextFloat()) {
            person.infect();
        }
    }

    protected void infect() {
        this.virus = new Virus(this.virus);
    }

    protected void recoverFromSickness() {
        this.virus = null;
        this.immunity += 0.3f;
    }

    public Point getPosition() {
        return position;
    }

    public float getHealthiness() {
        return healthiness;
    }

    public float getImmunity() {
        return immunity;
    }

    public float getActiveness() {
        return activeness;
    }

    public boolean isInfected() {
        if (virus != null) {
            return true;
        } else {
            return false;
        }
    }

    public void createFirstVirus(Virus virus)
    {
        this.virus = virus;
    }
}
