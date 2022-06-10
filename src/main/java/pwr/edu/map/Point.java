package pwr.edu.map;

public class Point {
    public int x;
    public int y;

    public Point() {};

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public float getDistance(Point point)
    {
        return (float) Math.sqrt((this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y));
    }
}
