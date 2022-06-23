package pl.pwr.edu.population;

import pl.pwr.edu.map.Point;
import pl.pwr.edu.virus.Virus;

import java.util.List;
import java.util.Random;

public abstract class Person {
    protected static final Random rand = new Random();
    protected Point position = new Point();
    protected boolean alive = true;
    protected float healthiness;
    protected float immunity;
    protected float activeness;
    protected Virus virus;

    public abstract void move(int mapSize, Person closestPerson);

    public void spreadVirus(Person person) {
        person.virus = new Virus(this.virus);
    }

    public void recoverFromSickness() {
        this.virus = null;
        this.immunity += 0.3f;
    }

    public boolean isInfected() {
        return virus != null;
    }

    public void createFirstVirus(Virus virus)
    {
        this.virus = virus;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public float getHealthiness() {
        return healthiness;
    }

    public void setHealthiness(float healthiness) {
        this.healthiness = healthiness;
    }

    public float getImmunity() {
        return immunity;
    }

    public void setImmunity(float immunity) {
        this.immunity = immunity;
    }

    public void setActiveness(float activeness) {
        this.activeness = activeness;
    }

    public Virus getVirus() {
        return virus;
    }

    public Person findClosestPerson(List<Person> people) {
        float smallestDistance = Float.MAX_VALUE;
        Person closestPerson = null;
        for (Person person : people)
        {
            if (this.position.getDistance(person.getPosition()) < smallestDistance)
            {
                closestPerson = person;
            }
        }

        return closestPerson;
    }
}
