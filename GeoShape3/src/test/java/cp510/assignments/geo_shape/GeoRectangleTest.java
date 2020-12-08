package cp510.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeoRectangleTest {

    int type = BufferedImage.TYPE_INT_ARGB;
    BufferedImage image = new BufferedImage(10, 10, type);
    Graphics2D gtx = (Graphics2D) image.createGraphics();

    @Test
    void constructorAndSetterGetterTests() {
        GeoRectangle rectangle;
        GeoRectangle rectangle2;
        GeoRectangle rectangle3;

        String testString1 = "origin=(5.0000,6.0000),color=#FF0000,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";
        String testString2 = "origin=(0.0000,0.0000),color=#0000FF,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";
        String testString3 = "origin=(3.0000,4.0000),color=#0000FF,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";

        GeoPoint point2 = new GeoPoint(3, 4);
        GeoPoint point3 = new GeoPoint(5, 6);

        rectangle = new GeoRectangle(point3, Color.red, 1, 2);
        rectangle2 = new GeoRectangle(1, 2);
        rectangle3 = new GeoRectangle(point2, 1, 2);

        assertEquals(testString1, rectangle.toString());
        assertEquals(testString2, rectangle2.toString());
        assertEquals(testString3, rectangle3.toString());

        rectangle.setWidth(10.1234456);
        assertEquals(10.1234456, rectangle.getWidth());
        rectangle.setHeight(20.1234567);
        assertEquals(20.1234567, rectangle.getHeight());
        rectangle.setColor(Color.darkGray);
        assertEquals(Color.darkGray, rectangle.getColor());
        rectangle.setOrigin(point2);
        GeoPoint newOrigin = rectangle.getOrigin();
        assertEquals(newOrigin, rectangle.getOrigin());
        rectangle.setEdgeColor(Color.magenta);
        assertEquals(Color.magenta, rectangle.getEdgeColor());
        rectangle.setEdgeWidth(5.0);
        assertEquals(5.0, rectangle.getEdgeWidth());

    }

    @Test
    void heightAndWidth() {
        GeoRectangle rectangle;
        GeoPoint point = new GeoPoint(1, 2);

        rectangle = new GeoRectangle(point, Color.red, 1, 2);

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        Assertions.assertEquals(10.1234456, rectangle.getWidth());
        Assertions.assertEquals(20.1234567, rectangle.getHeight());
        rectangle.draw(gtx);
    }

    @Test
    void equals() {
        GeoRectangle rectangle1;
        GeoRectangle rectangle2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(1, 2);
        GeoPoint point3 = new GeoPoint(4, 5);

        rectangle1 = new GeoRectangle(point1, Color.red, 1, 2);
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);

        assertTrue(rectangle1.equals(rectangle2));
        rectangle2 = null;
        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle1 = rectangle2;
        assertTrue(rectangle1.equals(rectangle2));
        rectangle2 = new GeoOval(point2, Color.red, 1, 2);
        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle2.setHeight(3);
        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle2.setWidth(3);

        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle2.setEdgeColor(Color.GREEN);

        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle2.setEdgeWidth(3);

        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle2.setOrigin(point3);

        assertFalse(rectangle1.equals(rectangle2));
        rectangle2 = new GeoRectangle(point2, Color.red, 1, 2);
        rectangle2.setColor(Color.CYAN);
        assertFalse(rectangle1.equals(rectangle2));
    }

    @Test
    void hashCodeTest() {
        GeoRectangle rectangle1;
        GeoRectangle rectangle2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        rectangle1 = new GeoRectangle(point1, Color.red, 1, 2);
        rectangle2 = new GeoRectangle(point2, Color.blue, 3, 4);

        assertEquals(-2080247776, rectangle1.hashCode());
        assertEquals(1137093983, rectangle2.hashCode());
    }

    @Test
    void toStringTest() {
        String testString1 = "origin=(1.0000,2.0000),color=#FF0000,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000";
        String testString2 = "origin=(3.0000,4.0000),color=#0000FF,edgeColor=#000000,edgeWidth=1.0000,width=3.0000,height=4.0000";

        GeoRectangle rectangle1;
        GeoRectangle rectangle2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        rectangle1 = new GeoRectangle(point1, Color.red, 1, 2);
        rectangle2 = new GeoRectangle(point2, Color.blue, 3, 4);

        assertEquals(testString1, rectangle1.toString());
        assertEquals(testString2, rectangle2.toString());
    }

    @Test
    void areaAndPerimeter() {
        GeoRectangle rectangle1;
        GeoRectangle rectangle2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        rectangle1 = new GeoRectangle(point1, Color.red, 1, 2);
        rectangle2 = new GeoRectangle(point2, Color.blue, 3, 4);

        assertEquals(2.0, rectangle1.area());
        assertEquals(6.0, rectangle1.perimeter());
        assertEquals(12.0, rectangle2.area());
        assertEquals(14.0, rectangle2.perimeter());
    }

}
