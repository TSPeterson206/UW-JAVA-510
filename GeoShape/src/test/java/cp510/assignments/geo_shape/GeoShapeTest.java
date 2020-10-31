package cp510.assignments.geo_shape;

import java.awt.Color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeoShapeTest {

    public static GeoShape shape = new GeoShape();
    public static GeoLine line = new GeoLine();
    public static GeoOval oval = new GeoOval();
    public static GeoPlane plane = new GeoPlane();
    public static GeoPoint point = new GeoPoint();
    public static GeoRectangle rectangle = new GeoRectangle();

    public static void main(String[] args) {
    };

//    @Test
//    void test() {
//        fail("Not yet implemented");
//    }

    // Tests GeoPoint

    @Test
    void xAndYCoordinates() {
        point.setXco(5.55555);
        point.setYco(4.44444);

        Assertions.assertEquals(5.55555, point.getXco());
        Assertions.assertEquals(4.44444, point.getYco());

    }

    // Tests GeoShape class
    @Test
    void color() {

        int argb = Color.RED.getRGB();
        String argc = String.format("#%06X", (argb & 0x00FFFFFF));

        shape.setColor(Color.RED);
        Assertions.assertEquals(Color.RED, shape.getColor());
    }

    // Tests GeoLine class
    @Test
    void start() {
        point.setXco(5.55555);
        ;
        point.setYco(4.44444);
        shape.setOrigin(point);
        line.setEnd(point);
        System.out.println("oringin shape" + shape);
        System.out.println("oringin line" + line);

        Assertions.assertEquals("(5.55555,4.44444)", line.getEnd());
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
        oval.setWidth(10.1234456);
        oval.setHeight(20.1234567);
        Assertions.assertEquals(10.1234456, oval.getWidth());
        Assertions.assertEquals(20.1234567, oval.getHeight());
    }

    // Tests GeoRectangle class
    @Test
    void area() {
        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);
        Assertions.assertEquals(203.7187191864055, rectangle.area());

    }

//Tests GeoRectangle class
    @Test
    void height() {
        rectangle.setWidth(50.33333);

        Assertions.assertEquals(50.33333, rectangle.getWidth());
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
        plane.setBackgroundColor(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, plane.getBackgroundColor());

    }

}
