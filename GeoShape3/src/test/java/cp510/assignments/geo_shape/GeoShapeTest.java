package cp510.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GeoShapeTest {

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

//    @Test
    void distance() {
        Assertions.assertEquals(0, distance);
    }

    // Tests GeoShape class
    @Test
    void colorTest() {
        point = new GeoPoint(4, 5);
        NestedTestClass newTest = new NestedTestClass(point, Color.black);
        Assertions.assertEquals(Color.black, newTest.getColor());
        newTest.setColor(Color.orange);
        Assertions.assertEquals(Color.orange, newTest.getColor());
    }

    @Test
    void originTest() {
        String testString1 = "origin=(4.0000,5.0000),color=#000000,edgeColor=null,edgeWidth=1.0";
        String testString2 = "origin=(6.0000,7.0000),color=#000000,edgeColor=null,edgeWidth=1.0";

        GeoPoint point = new GeoPoint(4, 5);
        GeoPoint point2 = new GeoPoint(6, 7);

        NestedTestClass newTest = new NestedTestClass(point, Color.black);
        Assertions.assertEquals(testString1, newTest.toString());
        newTest.setOrigin(point2);
        Assertions.assertEquals(testString2, newTest.toString());
        newTest.getOrigin();
    }

    @Test
    void edgeColorSetAndGet() {
        NestedTestClass newTest = new NestedTestClass(point, Color.black);
        newTest.setEdgeColor(Color.RED);
        Assertions.assertEquals(Color.RED, newTest.getEdgeColor());
    }

    @Test
    void edgeWidthSetAndGet() {
        NestedTestClass newTest = new NestedTestClass(point, Color.black);
        newTest.setEdgeWidth(2);
        Assertions.assertEquals(2.0, newTest.getEdgeWidth());
    }

    @Test
    void toStringTest() {
        NestedTestClass newTest = new NestedTestClass(point, Color.black);
        String result2 = newTest.toString();
        newTest.setEdgeColor(Color.GREEN);
        newTest.setColor(null);
        String result3 = newTest.toString();
        assertTrue(result2 != result3);
    }

    @Test
    void hashTest() {
        NestedTestClass newTest = new NestedTestClass(point, Color.black);
        Assertions.assertEquals(144896032, newTest.hashCode());
    }

    @Test
    void commonPropertiesTest() {
        NestedTestClass newTest1 = new NestedTestClass(point, Color.black);
        NestedTestClass newTest2 = new NestedTestClass(point, Color.black);
        NestedTestClass newTest3 = null;

        Assertions.assertTrue(newTest1.commonPropertiesEqual(newTest2));
        Assertions.assertFalse(newTest1.commonPropertiesEqual(newTest3));
        newTest1.setOrigin(point2);
        Assertions.assertFalse(newTest1.commonPropertiesEqual(newTest2));
    }

    @Test
    void testExpectedExceptionNullOriginRectangle() {
        rectangle = new GeoRectangle(point, Color.red, 1, 2);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                rectangle.setOrigin(null);
            }
        });
    }

    @Test
    void testExpectedExceptionNullOriginShape() {
        NestedTestClass test = new NestedTestClass(point, Color.blue);

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                NestedTestClass test = new NestedTestClass(null, Color.blue);
            }
        });

    }

    @Test
    void backgroundColorSetAndGetTest() {
        plane = new GeoPlane();

        plane.setBackgroundColor(Color.BLUE);
        Assertions.assertEquals(Color.BLUE, plane.getBackgroundColor());
    }

    private static class NestedTestClass extends GeoShape {
        public NestedTestClass(GeoPoint origin, Color color) {
            super(origin, color);
        }

        public static void main(String[] args) {
            NestedTestClass newOne = new NestedTestClass(point, Color.red);
            System.out.println(newOne.toString());
        }

        public void draw(Graphics2D gtx) {
        }

    }

}
