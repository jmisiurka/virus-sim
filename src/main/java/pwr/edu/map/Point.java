package pwr.edu.map;

public class Point {
    public int x;
    public int y;

    public float getDistance(Point point)
    {
        return (float) Math.sqrt((this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y));
    }
}
