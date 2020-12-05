package cp510.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeoPointTest {

    @Test
    void distance() {
        GeoPoint point1 = new GeoPoint(3, 4);
        GeoPoint point2 = new GeoPoint(7, 1);

        double x1 = point1.getXco();
        double y1 = point1.getYco();
        double x2 = point2.getXco();
        double y2 = point2.getYco();

        double result = Math
            .sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        System.out.println(result + " " + point1.distance(point2));
        assertEquals(5, point1.distance(point2));
    }

    @Test
    void getAndSetXAndYCoordinates() {
        GeoPoint point = new GeoPoint();

        point.setXco(5.55555);
        point.setYco(4.44444);
        double xcoValue = point.getXco();
        double ycoValue = point.getYco();

        GeoPoint point2 = new GeoPoint();
        point2.setXco(6.66666);
        point2.setYco(7.77777);

        Assertions.assertEquals(5.55555, xcoValue);
        Assertions.assertEquals(4.44444, ycoValue);
        Assertions.assertEquals("(5.5556,4.4444)", point.toString());
        Assertions.assertEquals(3.5136383309896884, point.distance(point2));
        double result = point.distance(point2);
        System.out.println("checking point distance" + result);
    }

    @Test
    void testingToString() {
        GeoPoint point = new GeoPoint();
        GeoPoint point2 = new GeoPoint(6, 7);

        point.setXco(5.55555);
        point.setYco(4.44444);
        Assertions.assertEquals("(5.5556,4.4444)", point.toString());
        Assertions.assertEquals("(6.0000,7.0000)", point2.toString());
    }

    // given junit test for equals
    @Test
    void testEqualsHash() {
        int xco1 = 100;
        int yco1 = xco1 + 50;
        int xco2 = 2 * xco1;
        int yco2 = 2 * yco1;
        GeoPoint pointA = new GeoPoint(xco1, yco1);
        GeoPoint pointB = new GeoPoint(xco1, yco1);

        assertNotEquals(pointA, null);
        assertNotEquals(pointA, new Object());
        assertEquals(pointA, pointA);
        assertEquals(pointA, pointB);
        assertEquals(pointB, pointA);
        assertEquals(pointA.hashCode(), pointB.hashCode());

        pointB.setXco(xco2);
        assertNotEquals(pointA, pointB);
        pointB.setXco(xco1);
        assertEquals(pointA, pointB);

        pointB.setYco(yco2);
        assertNotEquals(pointA, pointB);
    }

}
