package pl.pwr.edu.population;

import pl.pwr.edu.map.Point;

import java.util.Random;

public class PersonCreator {
    private static PersonParameters personParameters;
    private static final Random rand = new Random();

    public static void setPersonParameters(PersonParameters personParameters) {
        PersonCreator.personParameters = personParameters;
    }

    public Person createPerson(int mapSize)
    {
        Person person = new Person();
        person.setHealthiness(personParameters.getMinimumHealthiness() + rand.nextFloat() * (personParameters.getMaximumHealthiness() - personParameters.getMinimumHealthiness()));
        person.setImmunity(personParameters.getMinimumImmunity() + rand.nextFloat() * (personParameters.getMaximumImmunity() - personParameters.getMinimumImmunity()));
        person.setActiveness(personParameters.getMinimumActiveness() + rand.nextFloat() * (personParameters.getMaximumActiveness() - personParameters.getMinimumActiveness()));
        person.setPosition(new Point(rand.nextInt(mapSize), rand.nextInt(mapSize)));
        return person;
    }
}
