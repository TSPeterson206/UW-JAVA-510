package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoRectangle extends GeoShape {

    /**
     * The GeoRectangle class for UW java 510 assignment 4 (GeoShape part 1).
     * 
     * The GeoRectangle class extends the GeoShape class. It contains the width
     * and height of a rectangle object. It contains setters and getters for
     * height and width, as well as a method to calculate the area.
     * 
     * @author Toby Peterson.
     */

    double width;
//    The width of the rectangle.

    double height;
//    The height of the rectangle.

    double color;

    String colorConvert;

    /**
     * The setColor setter.
     * 
     * @param color The fill color of the generated rectangle. This is converted
     *              into a string format.
     */

    public void setColor(Color color) {
        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            this.colorConvert = String.format("#%06X", rgb);
        }
        ;
    };

    /**
     * The getWidth getter.
     * 
     * 
     * @return double The width value of the given rectangle.
     */
    public double getWidth() {
        return width;
    };

    /**
     * The setWidth setter.
     * 
     * @param width The width value of the given rectangle.
     */

    public void setWidth(double width) {
        this.width = width;
    };

    /**
     * The getHeight getter.
     * 
     * 
     * @return double The height value of the given rectangle.
     */

    public double getHeight() {
        return height;
    };

    /**
     * The setHeight setter.
     * 
     * @param height The fill color of the generated rectangle. This is
     *               converted into a string format.
     */

    public void setHeight(double height) {
        this.height = height;
    };

    /**
     * The area method for GeoRectangle.
     * 
     * @return double The area value of the width and height multiplied.
     */
    public double area() {
        return width * height;
    };

    /**
     * The perimeter method for GeoRectangle.
     * 
     * @return double The perimeter value of the width and height multiplied.
     */
    public double perimeter() {
        return 0;
    };

    /**
     * The toString method for GeoShape
     * 
     * @return String A human readable string of the origin, color, height, and
     *         width values for the generated shape.
     */

    public String toString() {
        return "origin=" + origin + ",color=" + colorConvert + ",width=" + width
        + ",height=" + height;
    };

}
