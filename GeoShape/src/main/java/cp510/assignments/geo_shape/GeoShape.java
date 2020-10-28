package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoShape {

    GeoPoint origin;
//    The x- and y- coordinates of the start of the shape. This property may never be null.

    Color color;
//    The fill color of the shape.

    String colorConvert;

    public GeoShape() {
    };

    public GeoPoint getOrigin() {
        return origin;
    };

    public void setOrigin(GeoPoint origin) {
        if (origin == null) {
            throw new NullPointerException();
        }
        ;
        this.origin = origin;
    };

    public Color getColor() {
        return this.color;
    };

    public void setColor(Color color) {
//        System.out.println("color in set color" + color);
//        this.color = color;
        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            this.colorConvert = String.format("#%06X", rgb);
//            System.out.println(String.format("#%06X", rgb));
        }

    };

    public String toString() {
        return "origin=" + origin + ",color=" + colorConvert;
    };
}
