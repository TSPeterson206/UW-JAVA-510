package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import uw.syp.java.tools.GWindow;

class GeoShapeTest<Expected> {

    Expected Exceptions;

//    private GeoShape shape = null;
    private GeoLine line;
    private GeoLine line2;
    private GeoLine line3;

    private GeoOval oval;
    private GeoOval oval2;
    private GeoOval oval3;

    private GeoPlane plane;
    private GeoPlane plane2;
    private static GeoPoint point = new GeoPoint(1, 2);
    private GeoPoint point2 = new GeoPoint(3, 4);

    private GeoRectangle rectangle;
    private GeoRectangle rectangle2;
    private GeoRectangle rectangle3;

    private static double xcoValue;
    private static double ycoValue;
    private static double distance;
    private static String pointString;
    private static GeoPoint lineString;

    private static String distanceString = "0.749766968903826";

    int type = BufferedImage.TYPE_INT_ARGB;
    BufferedImage image = new BufferedImage(10, 10, type);
    Graphics2D gtx = (Graphics2D) image.createGraphics();

    @BeforeEach
    public void tester() {
    }

    @Test
    void xAndYCoordinates() {
        point = new GeoPoint();

        point.setXco(5.55555);
        point.setYco(4.44444);
        xcoValue = point.getXco();
        ycoValue = point.getYco();
//        pointString = point.toString();

        GeoPoint point2 = new GeoPoint();
        point2.setXco(6.66666);
        point2.setYco(7.77777);

        Assertions.assertEquals(5.55555, xcoValue);
        Assertions.assertEquals(4.44444, ycoValue);
        Assertions.assertEquals("(5.5556,4.4444)", point.toString());
        Assertions.assertEquals(0.749766968903826, point.distance(point2));
        double result = point.distance(point2);
        System.out.println("checking point distance" + result);
//        assertTrue(distanceString.contains(result.toString());

    }

//
//    @Test
    void distance() {

        Assertions.assertEquals(0, distance);
    }

    // Tests GeoShape class
    @Test
    void color() {
        GeoShape shape = null;

        System.out.println("point: " + point + " " + point2);

        shape = new GeoLine(point, point2, Color.RED, 1);
        System.out.println("shape: " + shape);
        point = new GeoPoint();

        point.setXco(5.55555);
        point.setYco(4.44444);

        shape.setOrigin(point);
        shape.setEdgeColor(Color.RED);
        Assertions.assertEquals(Color.RED, shape.getEdgeColor());
        Assertions.assertEquals(
            "origin=(5.5556,4.4444),color=null,edgeColor=#FF0000,edgeWidth=1.0000,end=(3.0000,4.0000)",
            shape.toString());
        shape.setColor(null);
        Assertions.assertEquals(
            "origin=(5.5556,4.4444),color=null,edgeColor=#FF0000,edgeWidth=1.0000,end=(3.0000,4.0000)",
            shape.toString());

        GeoShape newShape = shape;
        String result = newShape.toString();
        System.out.println(result);

        StringTester newTest = new StringTester(point, Color.black);
        String result2 = newTest.toString();
        System.out.println(result2);
        newTest.setEdgeColor(Color.GREEN);
        System.out.println(newTest.toString());
        newTest.setColor(null);
        System.out.println(newTest.toString());

    }

    @Test
    void testExpectedExceptionNullOriginRectangle() {
//        final GeoShape shape = null;

        rectangle = new GeoRectangle(point, Color.red, 1, 2);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                rectangle.setOrigin(null);
            }
        });
    }

    @Test
    void testExpectedExceptionNullOriginShape() {
        StringTester test = new StringTester(point, Color.blue);

//        rectangle = new GeoRectangle(point, Color.red, 1, 2);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                StringTester test = new StringTester(null, Color.blue);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine2params() {
//        GeoLine test = new GeoLine(null, point);

//        rectangle = new GeoRectangle(point, Color.red, 1, 2);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                GeoLine test = new GeoLine(null, point, 1);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine3params() {

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                GeoLine test = new GeoLine(null, point, 1);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine4params() {
        GeoLine test = new GeoLine(point, point2, Color.RED, 1);

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                test.setOrigin(null);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine() {

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                GeoLine test = new GeoLine(null, point2, Color.RED, 1);
            }
        });

    }

    // Tests GeoLine class
    @Test
    void start() {

        line2 = new GeoLine(point, point2, 0);
        line3 = new GeoLine(point, point2);

        point = new GeoPoint();
        point.setXco(5.55555);
        point.setYco(4.44444);

        line = new GeoLine(point, point2, Color.RED, 0);
        line.setEnd(point);
        line.setStart(point);
        line.setColor(Color.RED);

        Assertions.assertEquals(point, line.getEnd());
        Assertions.assertEquals(point, line.getStart());
        Assertions.assertEquals(0, line.length());
        Assertions.assertEquals(
            "origin=(5.5556,4.4444),color=null,edgeColor=#FF0000,edgeWidth=1.0000,end=(5.5556,4.4444)",
            line.toString());

        Assertions.assertEquals(
            "origin=(5.5556,4.4444),color=null,edgeColor=#FF0000,edgeWidth=1.0000,end=(5.5556,4.4444)",
            line.toString());

        line.setColor(null);
        line.toString();
        line.setEdgeColor(null);
        line.draw(gtx);
        line.setColor(Color.BLUE);

        try {
            GeoLine test = new GeoLine(null, point2, Color.RED, 1);
        } catch (NullPointerException exc) {
            System.out.println(exc);
        }
    }

    @Test
    void testExpectedExceptionNullOriginLine() {

        line = new GeoLine(point, point2, Color.RED, 1);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                line.setEnd(null);
            }
        });
    }

//    @Test
    void end() {
        GeoLine reg = new GeoLine(point, point2, Color.RED, 1);

        Assertions.assertEquals(0, reg.getStart());
    }

    @Test
    void length() {
        GeoLine reg = new GeoLine(point, point2, Color.RED, 1);
//        Assertions.assertEquals(2, reg.setColor());
    }

//Tests GeoOval class
    @Test
    void widthAndHeight() {
        rectangle = new GeoRectangle(point, Color.red, 1, 2);

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        oval = new GeoOval(point, Color.red, 1, 2);
        oval2 = new GeoOval(1, 2);
        oval3 = new GeoOval(point, 1, 2);

        Assertions.assertEquals(0, oval.area());
        Assertions.assertEquals(0, oval.perimeter());
        Assertions.assertEquals(
            "origin=(1.0000,2.0000),color=#FF0000,edgeColor=#000000,edgeWidth=1.0000,width=1.0000,height=2.0000",
            oval.toString());
        oval.draw(gtx);
        oval.setColor(null);
        oval.toString();
//        Assertions.assertEquals(20.1234567, oval.getHeight());
    }

    // Tests GeoRectangle class
    @Test
    void area() {
        rectangle = new GeoRectangle(point, Color.red, 1, 2);
        rectangle2 = new GeoRectangle(1, 2);
        rectangle3 = new GeoRectangle(point, 1, 2);

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
        rectangle = new GeoRectangle(point, Color.red, 1, 2);

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        Assertions.assertEquals(10.1234456, rectangle.getWidth());
        Assertions.assertEquals(20.1234567, rectangle.getHeight());
        rectangle.draw(gtx);
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
        GWindow gWindow = null;

        List<GeoShape> geoList = new ArrayList<GeoShape>();

        GeoShape shape = null;
        shape = new GeoRectangle(point, Color.red, 1, 2);
        geoList.add(shape);
        plane = new GeoPlane();
        plane2 = new GeoPlane(Color.red);

        plane.show();
        plane.addShape(shape);
        plane.removeShape(shape);
        plane.removeShape(null);
        plane.getShapes();
//        plane.redraw();
        plane.setBackgroundColor(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, plane.getBackgroundColor());
//        Assertions.assertEquals(void, plane.show());
        plane.redraw(gtx);
//        plane.redraw();
//        gWindow.start();
    }

    private static class StringTester extends GeoShape {
        public StringTester(GeoPoint origin, Color color) {
            super(origin, color);
        }

        public static void main(String[] args) {
            StringTester newOne = new StringTester(point, Color.red);
            System.out.println(newOne.toString());
        }

        public void draw(Graphics2D gtx) {
        }

    }

}
