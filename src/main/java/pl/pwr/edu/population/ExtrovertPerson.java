package pl.pwr.edu.population;

public class ExtrovertPerson extends Person {

    @Override
    public void move(int mapSize, Person closestPerson) {
        if (activeness < rand.nextFloat())
        {
            return;
        }
        if (this.position.x < mapSize - 1 && this.position.x < closestPerson.position.x)
        {
            this.position.x++;
        } else if (this.position.x > 0 && this.position.x > closestPerson.position.x)
        {
            this.position.x--;
        } else {
            if (this.position.y < mapSize - 1 && this.position.y < closestPerson.position.y) {
                this.position.y++;
            } else if (this.position.y > 0 && this.position.y > closestPerson.position.y)
            {
                this.position.y--;
            }
        }
    }
}
