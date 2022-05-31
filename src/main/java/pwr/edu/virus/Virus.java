package pwr.edu.virus;

public class Virus {
    private static float mutability;
    private float infectivity;
    private float deadliness;

    public Virus()
    {

    }

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
    }
}
