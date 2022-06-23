package pl.pwr.edu.population;

import pl.pwr.edu.map.Point;

import java.util.Random;

public class PersonCreator {
    private PersonParameters personParameters;
    private final Random rand = new Random();

    public void setPersonParameters(PersonParameters personParameters) {
        this.personParameters = personParameters;
    }

    public Person createPerson(int mapSize)
    {
        float personType = rand.nextFloat();
        Person person;

        if (personType <= personParameters.getIntrovertProbability())
        {
            person = new IntrovertPerson();
        } else if (personType > personParameters.getIntrovertProbability() &&
                personType < personParameters.getExtrovertProbability() + personParameters.getIntrovertProbability())
        {
            person = new ExtrovertPerson();
        } else {
            person = new AmbivertPerson();
        }

        person.setHealthiness(personParameters.getMinimumHealthiness() + rand.nextFloat() * (personParameters.getMaximumHealthiness() - personParameters.getMinimumHealthiness()));
        person.setImmunity(personParameters.getMinimumImmunity() + rand.nextFloat() * (personParameters.getMaximumImmunity() - personParameters.getMinimumImmunity()));
        person.setActiveness(personParameters.getMinimumActiveness() + rand.nextFloat() * (personParameters.getMaximumActiveness() - personParameters.getMinimumActiveness()));
        person.setPosition(new Point(rand.nextInt(mapSize), rand.nextInt(mapSize)));
        return person;
    }
}
