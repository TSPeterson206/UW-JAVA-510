package cp510.assignments.geo_shape;

import java.awt.Color;

/**
 * The GeoShape class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoShape class determines the origin point of the generated shape. It
 * contains x and y coordinates and the fill color for the shape. It also
 * contains setters and getters for these two attributes. This class
 * encapsulates functionality common to all shapes in the geo_shape package.
 * 
 * @author Toby Peterson.
 */
public class GeoShape {

//    private GeoPoint origin;
    private GeoPoint origin = new GeoPoint();

    protected Color color;

    private String originConvert;

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
     * Returns the origin of this shape.
     * 
     * @return The GeoPoint origin coordinates.
     */
    public GeoPoint getOrigin() {
        return this.origin;
    };

    /**
     * The setOrigin setter.
     * 
     * Sets the origin of this shape to a given value. The given value may not
     * be null. If the given value is null a NullPointerException will be
     * thrown.
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
     * Returns the fill color of this shape.
     * 
     * @return The fill color for the generated shape.
     */
    public Color getColor() {
        return this.color;
    };

    /**
     * The setColor setter.
     * 
     * Sets the fill color of this shape to a given value. (Note: color may be
     * null.).
     * 
     * @param color The fill color of the generated shape. This is converted
     *              into a string format.
     */
    public void setColor(Color color) {
//        String colorConvert;
//
//        if (color != null) {
//            int argb = color.getRGB();
//            int rgb = argb & 0x00FFFFFF;
//            colorConvert = String.format("#%06X", rgb);
//            this.color = color;
//        }
//        ;
        this.color = color;
    };

    /**
     * The toString method for GeoShape
     * 
     * Returns a string describing the origin and color properties of this
     * GeoShape.
     * 
     * @return A human readable string of the origin and color values for the
     *         generated shape.
     */
    public String toString() {

        String colorConvert = null;

        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            colorConvert = String.format("#%06X", rgb);
//            this.color = color;
        } else {
            color = null;
        }
        ;

//        if (origin == null) {
//            return "origin=" + "(0.0000,0.0000)" + ",color=" + colorConvert;
//        }
        return "origin=" + origin + ",color=" + colorConvert;
    };
}
