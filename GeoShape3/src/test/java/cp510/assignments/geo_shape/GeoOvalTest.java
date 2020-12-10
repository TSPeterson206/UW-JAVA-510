package cp510.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeoOvalTest {

//private static final String GeoOvalTest = null;

//    private GeoPlane plane;

    @BeforeEach
    void testable() {
        Figures figures = new Figures();

    }

    @Test
    void constructorAndSetterGetterTests() {
        GeoOval oval1;
        GeoOval oval2;
        GeoOval oval3;

        String testString1 = "origin=(5.0000,7.0000),color=#FF0000,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";
        String testString2 = "origin=(0.0000,0.0000),color=#0000FF,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";
        String testString3 = "origin=(5.0000,6.0000),color=#0000FF,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";

        GeoPoint point = new GeoPoint(3, 4);
        GeoPoint point2 = new GeoPoint(5, 6);
        GeoPoint point3 = new GeoPoint(5, 7);

        oval1 = new GeoOval(point3, Color.red, 1, 2);
        oval2 = new GeoOval(1, 2);
        oval3 = new GeoOval(point2, 1, 2);

        assertEquals(testString1, oval1.toString());
        assertEquals(testString2, oval2.toString());
        assertEquals(testString3, oval3.toString());

        oval1.setWidth(10.1234456);
        assertEquals(10.1234456, oval1.getWidth());
        oval1.setHeight(20.1234567);
        assertEquals(20.1234567, oval1.getHeight());
        oval1.setColor(Color.darkGray);
        assertEquals(Color.darkGray, oval1.getColor());
        oval1.setOrigin(point2);
        GeoPoint newOrigin = oval1.getOrigin();
        assertEquals(newOrigin, oval1.getOrigin());
        oval1.setEdgeColor(Color.magenta);
        assertEquals(Color.magenta, oval1.getEdgeColor());
        oval1.setEdgeWidth(5.0);
        assertEquals(5.0, oval1.getEdgeWidth());
    }

    @Test
    void equals() {
        GeoOval oval1;
        GeoOval oval2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(1, 2);
        GeoPoint point3 = new GeoPoint(4, 5);

        GeoRectangle rect = new GeoRectangle(point2, Color.red, 1, 2);

        oval1 = new GeoOval(point1, Color.red, 1, 2);
        oval2 = new GeoOval(point2, Color.red, 1, 2);

        assertTrue(oval1.equals(oval2));
        oval2 = null;
        assertFalse(oval1.equals(oval2));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval1 = oval2;
        assertTrue(oval1.equals(oval2));
//        oval2 = new GeoRectangle(point2, Color.red, 1, 2);
        assertFalse(oval1.equals(rect));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval2.setHeight(3);
        assertFalse(oval1.equals(oval2));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval2.setWidth(3);

        assertFalse(oval1.equals(oval2));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval2.setEdgeColor(Color.GREEN);

        assertFalse(oval1.equals(oval2));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval2.setEdgeWidth(3);

        assertFalse(oval1.equals(oval2));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval2.setOrigin(point3);

        assertFalse(oval1.equals(oval2));
        oval2 = new GeoOval(point2, Color.red, 1, 2);
        oval2.setColor(Color.CYAN);
        assertFalse(oval1.equals(oval2));
    }

    @Test
    void hashCodeTest() {
        GeoRectangle oval1;
        GeoRectangle oval2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        oval1 = new GeoOval(point1, Color.red, 1, 2);
        oval2 = new GeoOval(point2, Color.blue, 3, 4);

        assertEquals(-1405720544, oval1.hashCode());
        assertEquals(-1916743265, oval2.hashCode());
    }

    @Test
    void toStringTest() {
        String testString1 = "origin=(1.0000,2.0000),color=#FF0000,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";
        String testString2 = "origin=(3.0000,4.0000),color=#0000FF,edgeColor=#000000,edgeWidth=1.0000,width=3.0000,height=4.0000";

        GeoOval oval1;
        GeoOval oval2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        oval1 = new GeoOval(point1, Color.red, 1, 2);
        oval2 = new GeoOval(point2, Color.blue, 3, 4);

        assertEquals(testString1, oval1.toString());
        assertEquals(testString2, oval2.toString());
    }

    @Test
    void areaAndPerimeter() {
        GeoOval oval1;
        GeoOval oval2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        oval1 = new GeoOval(point1, Color.red, 1, 2);
        oval2 = new GeoOval(point2, Color.blue, 3, 4);

        assertEquals(1.5707963267948966, oval1.area());
        assertEquals(4.967294132898051, oval1.perimeter());
        assertEquals(9.42477796076938, oval2.area());
        assertEquals(11.107207345395915, oval2.perimeter());
    }
}
