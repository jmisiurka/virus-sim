package pl.pwr.edu.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    void givenTwoPoints_calculateDistance()
    {
        Point p1 = new Point(3, 6);
        Point p2 = new Point(4, 6);
        float distance = p1.getDistance(p2);
        assertEquals(distance, 1);
    }
}
