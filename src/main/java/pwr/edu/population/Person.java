package pwr.edu.population;

import pwr.edu.virus.Virus;
import pwr.edu.map.Point;

import java.util.Random;

public class Person {
    private static Random rand = new Random();
    private Point position = new Point();
    private boolean alive = true;
    private float healthiness;
    private float immunity;
    private float activeness;
    private Virus virus;

    private void die() {
        virus = null;
    }

    public void move(int mapSize) {
        if (activeness < rand.nextFloat())
        {
            return;
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
    }

    public void spreadVirus(Person person) {
        if (this.isInfected() && person.getImmunity() < new Random().nextFloat()) {
            person.infect();
        }
    }

    protected void infect() {
        this.virus = new Virus(this.virus);
    }

    public void recoverFromSickness() {
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

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setHealthiness(float healthiness) {
        this.healthiness = healthiness;
    }

    public void setImmunity(float immunity) {
        this.immunity = immunity;
    }

    public void setActiveness(float activeness) {
        this.activeness = activeness;
    }

    public boolean isInfected() {
        if (virus != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void createFirstVirus(Virus virus)
    {
        this.virus = virus;
    }
}
