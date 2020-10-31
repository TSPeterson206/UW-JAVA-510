package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoShape {

    /**
     * The GeoShape class for UW java 510 assignment 4 (GeoShape part 1).
     * 
     * The GeoShape class determines the origin point of the generated shape. It
     * contains x and y coordinates and the fill color for the shape. It also
     * contains setters and getters for these two attributes.
     * 
     * @author Toby Peterson.
     */

    GeoPoint origin;
//    The x- and y- coordinates of the start of the shape. This property may never be null.

    Color color;
//    The fill color of the shape.

    String colorConvert;

    /**
     * GeoShape constructor.
     * 
     * The constructor to initiate an instance of GeoShape.
     */

    public GeoShape() {
    };

    /**
     * The getOrigin getter.
     * 
     * @return The GeoPoint origin coordinates.
     */

    public GeoPoint getOrigin() {
        return this.origin;
    };

    /**
     * The setOrigin setter.
     * 
     * @throws NullPointerException of the submitted origin is null.
     */

    public void setOrigin(GeoPoint origin) {
        if (origin == null) {
            throw new NullPointerException(
            "Life is about substance. This can't be null.");
        }
        ;
        this.origin = origin;
    };

    /**
     * The getColor getter.
     * 
     * @return The fill color for the generated shape.
     */

    public Color getColor() {
        return this.color;
    };

    /**
     * The setColor setter.
     * 
     * @param color The fill color of the generated shape. This is converted
     *              into a string format.
     */

    public void setColor(Color color) {
        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            this.colorConvert = String.format("#%06X", rgb);
        }
        ;
        this.color = color;

    };

    /**
     * The toString method for GeoShape
     * 
     * @return A human readable string of the origin and color values for the
     *         generated shape.
     */

    public String toString() {
        if (origin == null) {
            return "origin=" + "(0.0000,0.0000)" + ",color=" + colorConvert;
        }
        return "origin=" + origin + ",color=" + colorConvert;
    };
}
