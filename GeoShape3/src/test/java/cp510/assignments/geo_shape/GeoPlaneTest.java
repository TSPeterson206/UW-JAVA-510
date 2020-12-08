package cp510.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeoPlaneTest {

    GeoPlane plane = new GeoPlane(Color.black);

    int type = BufferedImage.TYPE_INT_ARGB;
    BufferedImage image = new BufferedImage(10, 10, type);
    Graphics2D gtx = (Graphics2D) image.createGraphics();

    @Test
    void redrawTest() {

        GeoPlane plane = new GeoPlane();
        GeoPoint point1 = new GeoPoint(1, 2);
        GeoOval oval = new GeoOval(point1, Color.red, 1, 2);
        plane.addShape(oval);
        plane.redraw(gtx);
        plane.show();
        plane.redraw();
    }

    @Test
    void show() {
        GeoPlane plane = new GeoPlane();

        GeoLine line1;
        GeoLine line2;

        GeoPoint point1 = new GeoPoint(1, 2);
        GeoPoint point2 = new GeoPoint(3, 4);

        line1 = new GeoLine(point1, point2, Color.red, 1);
        line2 = new GeoLine(point2, point1, Color.blue, 3);

        plane.addShape(line1);
        plane.addShape(line2);
        plane.redraw(gtx);
        plane.show();
    }

    @Test
    void getAndRemoveShapes() {
        GeoPoint point = new GeoPoint(1, 2);
        GeoShape shape = new GeoRectangle(point, Color.red, 1, 2);
        GeoShape shape2 = new GeoRectangle(point, Color.blue, 3, 4);
        GeoShape shape3 = new GeoRectangle(point, Color.white, 5, 6);
        GeoShape shape4 = new GeoRectangle(point, Color.green, 7, 8);

        GeoPlane plane = new GeoPlane(Color.red);

        plane.addShape(shape);
        Assertions.assertEquals(1, plane.getShapes().size());
        plane.addShape(shape2);
        Assertions.assertEquals(2, plane.getShapes().size());
        plane.removeShape(shape);
        Assertions.assertEquals(1, plane.getShapes().size());
        plane.removeShape(shape2);
        Assertions.assertEquals(0, plane.getShapes().size());
        Assertions.assertEquals(null, plane.removeShape(shape3));
    }

    @Test
    void bufferedImage() {
        // Per instructor, getBitmap returns null due to some students having
        // issues with this method of GWindow working.
        GeoPlane plane = new GeoPlane(Color.red);
        Assertions.assertEquals(null, plane.getBitmap());
    }

    @Test
    void backgroundColors() {
        GeoPlane plane = new GeoPlane(Color.orange);
        assertEquals(Color.orange, plane.getBackgroundColor());
        plane.setBackgroundColor(Color.PINK);
        assertEquals(Color.PINK, plane.getBackgroundColor());
    }

}
