package pl.pwr.edu.population;

public class PersonParameters {
    private final float minimumHealthiness;
    private final float minimumImmunity;
    private final float minimumActiveness;
    private final float maximumHealthiness;
    private final float maximumImmunity;
    private final float maximumActiveness;

    public PersonParameters(float minimumHealthiness, float minimumImmunity, float minimumActiveness,
                            float maximumHealthiness, float maximumImmunity, float maximumActiveness) {
        this.minimumHealthiness = minimumHealthiness;
        this.minimumImmunity = minimumImmunity;
        this.minimumActiveness = minimumActiveness;
        this.maximumHealthiness = maximumHealthiness;
        this.maximumImmunity = maximumImmunity;
        this.maximumActiveness = maximumActiveness;
    }

//    public static void setParameters(float minimumHealthiness, float minimumImmunity, float minimumActiveness,
//                                     float maximumHealthiness, float maximumImmunity, float maximumActiveness) {
//        PersonParameters.minimumHealthiness = minimumHealthiness;
//        PersonParameters.minimumImmunity = minimumImmunity;
//        PersonParameters.minimumActiveness = minimumActiveness;
//        PersonParameters.maximumHealthiness = maximumHealthiness;
//        PersonParameters.maximumImmunity = maximumImmunity;
//        PersonParameters.maximumActiveness = maximumActiveness;
//    }

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
}