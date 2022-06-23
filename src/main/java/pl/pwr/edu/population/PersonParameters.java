package pl.pwr.edu.population;

public class PersonParameters {
    private final float minimumHealthiness;
    private final float minimumImmunity;
    private final float minimumActiveness;
    private final float maximumHealthiness;
    private final float maximumImmunity;
    private final float maximumActiveness;
    private final float extrovertProbability;
    private final float introvertProbability;

    public PersonParameters(float minimumHealthiness, float minimumImmunity, float minimumActiveness,
                            float maximumHealthiness, float maximumImmunity, float maximumActiveness,
                            float extrovertPercentage, float introvertPercentage) {
        this.minimumHealthiness = minimumHealthiness;
        this.minimumImmunity = minimumImmunity;
        this.minimumActiveness = minimumActiveness;
        this.maximumHealthiness = maximumHealthiness;
        this.maximumImmunity = maximumImmunity;
        this.maximumActiveness = maximumActiveness;
        this.extrovertProbability = extrovertPercentage;
        this.introvertProbability = introvertPercentage;
    }

    public float getMinimumHealthiness() {
        return minimumHealthiness;
    }

    public float getMinimumImmunity() {
        return minimumImmunity;
    }

    public float getMinimumActiveness() {
        return minimumActiveness;
    }

    public float getMaximumHealthiness() {
        return maximumHealthiness;
    }

    public float getMaximumImmunity() {
        return maximumImmunity;
    }

    public float getMaximumActiveness() {
        return maximumActiveness;
    }

    public float getExtrovertProbability() {
        return extrovertProbability;
    }

    public float getIntrovertProbability() {
        return introvertProbability;
    }
}
