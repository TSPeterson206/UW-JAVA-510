package cp510.assignments.geo_shape;

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
    void area() {
        GeoRectangle rectangle;
        GeoRectangle rectangle2;
        GeoRectangle rectangle3;

        GeoPoint point = new GeoPoint(1, 2);
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

    @Test
    void height() {
        GeoRectangle rectangle;
        GeoPoint point = new GeoPoint(1, 2);

        rectangle = new GeoRectangle(point, Color.red, 1, 2);

        rectangle.setWidth(10.1234456);
        rectangle.setHeight(20.1234567);

        Assertions.assertEquals(10.1234456, rectangle.getWidth());
        Assertions.assertEquals(20.1234567, rectangle.getHeight());
        rectangle.draw(gtx);
    }

}
