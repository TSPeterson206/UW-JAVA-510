package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeoOvalTest {

    int type = BufferedImage.TYPE_INT_ARGB;
    BufferedImage image = new BufferedImage(10, 10, type);
    Graphics2D gtx = (Graphics2D) image.createGraphics();

    @Test
    void widthAndHeight() {

        GeoPoint point = new GeoPoint(1, 2);

        GeoRectangle rectangle = new GeoRectangle(point, Color.red, 1, 2);

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        GeoOval oval = new GeoOval(point, Color.red, 1, 2);
        GeoOval oval2 = new GeoOval(1, 2);
        GeoOval oval3 = new GeoOval(point, 1, 2);

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

}
