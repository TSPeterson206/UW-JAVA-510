package cp510.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GeoLineTest {

    int type = BufferedImage.TYPE_INT_ARGB;
    BufferedImage image = new BufferedImage(10, 10, type);
    Graphics2D gtx = (Graphics2D) image.createGraphics();

    @Test
    void start() {

        GeoLine line;
        GeoLine line2;
        GeoLine line3;

        GeoPoint point = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

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
    void startAndEnd() {
        GeoPoint point = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);
        GeoLine line = new GeoLine(point, point2, Color.RED, 1);

        Assertions.assertEquals(point2, line.getEnd());
        Assertions.assertEquals(point, line.getStart());
    }

    @Test
    void length() {
        GeoPoint point = new GeoPoint(1, 2);

        GeoPoint point2 = new GeoPoint(3, 4);
        GeoLine reg = new GeoLine(point, point2, Color.RED, 1);
        Assertions.assertEquals(2.8284271247461903, reg.length());
    }

    @Test
    void testExpectedExceptionNullStartLine2params() {
        GeoPoint point = new GeoPoint(1, 2);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                GeoLine test = new GeoLine(null, point, 1);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine3params() {
        GeoPoint point = new GeoPoint(1, 2);
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                GeoLine test = new GeoLine(null, point, 1);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine4params() {
        GeoPoint point = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        GeoLine test = new GeoLine(point, point2, Color.RED, 1);

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                test.setOrigin(null);
            }
        });

    }

    @Test
    void testExpectedExceptionNullStartLine() {
        GeoPoint point2 = new GeoPoint(3, 4);

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                GeoLine test = new GeoLine(null, point2, Color.RED, 1);
            }
        });
    }

    @Test
    void testExpectedExceptionsetEnd() {
        GeoPoint point = new GeoPoint(1, 2);

        GeoPoint point2 = new GeoPoint(3, 4);

        GeoLine test = new GeoLine(point, point2, Color.RED, 1);

        Assertions.assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                test.setEnd(null);
            }
        });
    }

    @Test
    void equals() {
        GeoLine line1;
        GeoLine line2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(1, 2);
        GeoPoint point3 = new GeoPoint(4, 5);
        GeoPoint point4 = new GeoPoint(4, 5);

        GeoRectangle rect = new GeoRectangle(point1, Color.BLACK, 2, 1);

        line1 = new GeoLine(point1, point3, Color.red, 1);
        line2 = new GeoLine(point1, point3, Color.red, 1);

        assertTrue(line1.equals(line2));
        line2 = null;
        assertFalse(line1.equals(line2));
        line2 = new GeoLine(point1, point3, Color.red, 1);
        line1 = line2;
        assertTrue(line1.equals(line2));
        assertFalse(line1.equals(rect));
        line2 = new GeoLine(point1, point3, Color.red, 1);
        line2.setEdgeColor(Color.GREEN);

        assertFalse(line1.equals(line2));
        line2 = new GeoLine(point1, point3, Color.red, 1);
        line2.setEdgeWidth(3);

        assertFalse(line1.equals(line2));
        line2 = new GeoLine(point1, point3, Color.red, 1);
        line2.setOrigin(point3);

        assertFalse(line1.equals(line2));
        line1 = new GeoLine(point1, point3, Color.red, 1);
        line2 = new GeoLine(point1, point3, Color.red, 1);
        line2.setColor(Color.CYAN);
        assertTrue(line1.equals(line2));
        line2 = new GeoLine(point1, point3, Color.red, 1);
        line2.setEnd(point2);
        assertFalse(line1.equals(line2));

    }

    @Test
    void hashCodeTest() {
        GeoLine line1;
        GeoLine line2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        line1 = new GeoLine(point1, point2, Color.red, 1);
        line2 = new GeoLine(point2, point1, Color.blue, 3);

        assertEquals(1319856192, line1.hashCode());
        assertEquals(566454336, line2.hashCode());
    }

    @Test
    void toStringTest() {
        String testString1 = "origin=(1.0000,2.0000),color=null,edgeColor=#FF0000,edgeWidth=1.0000,end=(3.0000,4.0000)";
        String testString2 = "origin=(3.0000,4.0000),color=null,edgeColor=#0000FF,edgeWidth=3.0000,end=(1.0000,2.0000)";

        GeoLine line1;
        GeoLine line2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        line1 = new GeoLine(point1, point2, Color.red, 1);
        line2 = new GeoLine(point2, point1, Color.blue, 3);

        assertEquals(testString1, line1.toString());
        assertEquals(testString2, line2.toString());
    }

    @Test
    void lengthTest() {
        GeoLine line1;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);
        line1 = new GeoLine(point1, point2, Color.red, 1);

        Assertions.assertEquals(2.8284271247461903, line1.length());
    }

}
