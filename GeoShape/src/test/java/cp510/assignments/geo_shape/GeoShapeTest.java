package cp510.assignments.geo_shape;

import java.awt.Color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeoShapeTest {

    public static GeoShape shape;
    public static GeoLine line;
    public static GeoOval oval;
    public static GeoPlane plane;
    public static GeoPoint point;
    public static GeoRectangle rectangle;

    public static double xcoValue;
    public static double ycoValue;
    public static double distance;
    public static String pointString;
    public static GeoPoint lineString;

    public static void main(String[] args) {
        shape = new GeoShape();
        line = new GeoLine();
        oval = new GeoOval();
        plane = new GeoPlane();
        point = new GeoPoint();
        rectangle = new GeoRectangle();
//GeoPoint
        point.setXco(5.55555);
        point.setYco(4.44444);
        xcoValue = point.getXco();
        ycoValue = point.getYco();
        distance = point.distance(point);
        pointString = point.toString();
// GeoShape
        shape.setOrigin(point);
        shape.getOrigin();
        shape.setColor(Color.RED);
        shape.getColor();
        shape.toString();

// GeoRectangle
        rectangle.setWidth(1.0000);
        rectangle.setHeight(2.0000);
        rectangle.getWidth();
        rectangle.getHeight();
        rectangle.area();
        rectangle.perimeter();
        rectangle.setColor(Color.RED);
        rectangle.toString();

        // GeoOval
        oval.area();
        oval.perimeter();
// GeoLine

        line.setEnd(point);
        line.getEnd();
        line.setStart(point);
        line.getStart();
        line.length();
        line.toString();
        line.setColor(Color.RED);
// GeoPlane
        plane.show();
        plane.addShape(shape);
        plane.removeShape(shape);
        plane.redraw();
        plane.setBackgroundColor(Color.RED);
        plane.getBackgroundColor();
    };

    // Tests GeoPoint

    @Test
    void xAndYCoordinates() {
        point = new GeoPoint();

        point.setXco(5.55555);
        point.setYco(4.44444);
        xcoValue = point.getXco();
        ycoValue = point.getYco();
        pointString = point.toString();

        Assertions.assertEquals(5.55555, xcoValue);
        Assertions.assertEquals(4.44444, ycoValue);
        Assertions.assertEquals("(5.5556,4.4444)", pointString);

    }

    @Test
    void distance() {

        Assertions.assertEquals(0, distance);
    }

    // Tests GeoShape class
    @Test
    void color() {
        shape = new GeoShape();

        point = new GeoPoint();

        point.setXco(5.55555);
        point.setYco(4.44444);

        shape.setOrigin(point);
        shape.setColor(Color.RED);
        Assertions.assertEquals(Color.RED, shape.getColor());
    }

    // Tests GeoLine class
    @Test
    void start() {
        point = new GeoPoint();
        point.setXco(5.55555);
        point.setYco(4.44444);
//        shape = new GeoShape();

        line = new GeoLine();
        line.setEnd(point);
//        System.out.println(point);
//        GeoPoint lineString = line.getEnd();

        Assertions.assertEquals(point, line.getEnd());
    }

//
//    @Test
//    void end() {
//
//        Assertions.assertEquals(0, reg.getStart());
//    }
//
//    @Test
//    void length() {
//
//        Assertions.assertEquals(2, reg.getCount());
//    }

//Tests GeoOval class
    @Test
    void widthAndHeight() {
        rectangle = new GeoRectangle();

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        oval = new GeoOval();
//        System.out.println("rectangle and oval " + rectangle + "  " + oval
//        + "zxzx" + rectangle.getHeight());
        Assertions.assertEquals(0, oval.area());
//        Assertions.assertEquals(20.1234567, oval.getHeight());
    }

    // Tests GeoRectangle class
    @Test
    void area() {
        rectangle = new GeoRectangle();

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);
        rectangle.getWidth();
        rectangle.getHeight();
        rectangle.area();
        rectangle.perimeter();
        rectangle.setColor(Color.RED);
        rectangle.toString();
        Assertions.assertEquals(203.7187191864055, rectangle.area());

    }

//Tests GeoRectangle class
    @Test
    void height() {
//        rectangle.setWidth(50.33333);
        rectangle = new GeoRectangle();

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        Assertions.assertEquals(10.1234456, rectangle.getWidth());
        Assertions.assertEquals(20.1234567, rectangle.getHeight());

    }

//
//    @Test
//    void perimeter() {
//
//        Assertions.assertEquals(0, reg.getSecurity());
//    }

//Tests GeoPlane class
    @Test
    void backgroundColor() {
        plane = new GeoPlane();
        plane.setBackgroundColor(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, plane.getBackgroundColor());

    }

}
