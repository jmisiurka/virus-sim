package pl.pwr.edu.population;

public class AmbivertPerson extends Person {

    @Override
    public void move(int mapSize, Person closestPerson) {
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
}
