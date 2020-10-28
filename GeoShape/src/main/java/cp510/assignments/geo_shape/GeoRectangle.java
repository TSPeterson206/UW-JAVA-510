package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoRectangle extends GeoShape {

    double width;
//    The width of the rectangle.

    double height;
//    The height of the rectangle.

    double color;

    String colorConvert;

    public void setColor(Color color) {
        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            this.colorConvert = String.format("#%06X", rgb);
        }
        ;
    };

//    public double getColor() {
//        return null;
//    };

    public double getWidth() {
        return width;
    };

    public void setWidth(double width) {
        this.width = width;
    };

    public double getHeight() {
        return height;
    };

    public void setHeight(double height) {
        this.height = height;
    };

    public double area() {
        return width * height;
    };

    public double perimeter() {
        return 0;
    };

    public String toString() {
        return "origin=" + origin + ",color=" + colorConvert + ",width=" + width
        + ",height=" + height;
    };

}
