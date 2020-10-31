package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoLine extends GeoShape {

    /**
     * The GeoLine class for UW java 510 assignment 4 (GeoShape part 1).
     * 
     * The GeoLine class extends the GeoShape class. It contains getters and
     * setters for start and end properties, as well as a method to calculate
     * the length of a line.
     * 
     * @author Toby Peterson.
     */

    GeoPoint end;
//    The end of the line.

    GeoPoint start;
    // The start of the line.

    String colorConvert;

    /**
     * The setColor method for GeoLine.
     * 
     * @param color The intended color of the line. This method sets the line
     *              color as a human readable string.
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
     * The getEnd method for GeoLine.
     * 
     * @return The end point of the line.
     */

    public GeoPoint getEnd() {
        return end;
    };

    /**
     * The setEnd method for GeoLine.
     * 
     * @param end The intended end point of the given line.
     */

    public void setEnd(GeoPoint end) {
        if (end == null) {
            throw new NullPointerException(
            "Life is about substance. This can't be null.");
        }
        this.end = end;
    };

    /**
     * The getStart method for GeoLine.
     * 
     * @return The start point of the line.
     */

    public GeoPoint getStart() {
//        return this.start;
        System.out.println("origin" + origin);
        return start;
    };

    /**
     * The setStart method for GeoLine.
     * 
     * @param start The intended start point of the given line.
     */

    public void setStart(GeoPoint start) {

        this.start = start;
    };

    /**
     * The length method for GeoLine.
     * 
     * @return The length of the given line.
     */
    public double length() {
        return 0;
    };

    /**
     * The toString method for GeoLine
     * 
     * @return A human readable string of the origin,color and end values for
     *         the generated line.
     */

    public String toString() {
        return "origin=" + origin + ",color=" + colorConvert + ",end=" + end;
    };
}
