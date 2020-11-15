package cp510.assignments.geo_shape;

import java.awt.Color;

/**
 * The GeoLine class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoLine class extends the GeoShape class. It contains getters and setters
 * for start and end properties, as well as a method to calculate the length of
 * a line. This class encapsulates a line.
 * 
 * @author Toby Peterson.
 */
public class GeoLine extends GeoShape {

//    GeoPoint end;
    private GeoPoint start;
//    GeoPoint start = getOrigin();

    private Color tempColor;

    private GeoPoint end = new GeoPoint();

    /**
     * The getEnd method for GeoLine.
     * 
     * Returns the end point of this line.
     * 
     * @return The end point of the line.
     */
    public GeoPoint getEnd() {
        return end;
    };

    /**
     * The setEnd method for GeoLine.
     * 
     * Sets the end point of this line to the given value. The given value must
     * not be null; if it is null, a NullPointerException will be thrown.
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
     * Returns the starting point of this line.The starting point of the line is
     * determined by the origin, which is stored in the GeoShape superclass.
     * 
     * @return The start point of the line.
     */
    public GeoPoint getStart() {
//        return start;
        return getOrigin();
    };

    /**
     * The setStart method for GeoLine.
     * 
     * Sets the starting point of the line. Calling this method is equivalent to
     * calling setOrigin(GeoPoint).
     * 
     * @param start The intended start point of the given line.
     */
    public void setStart(GeoPoint start) {
        setOrigin(start);
    };

    /**
     * The length method for GeoLine.
     * 
     * Returns the length of this line.
     * 
     * @return The length of the given line.
     */
    public double length() {
        // Currently a stub.
        return 0;
    };

    /**
     * The toString method for GeoLine.
     * 
     * Returns a string describing the properties of this line.
     * 
     * @return A human readable string of the origin,color and end values for
     *         the generated line.
     */
    public String toString() {
        String colorConvert = null;
        System.out.println("testing color" + getColor());
        if (getColor() != null) {
            int argb = this.color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            colorConvert = String.format("#%06X", rgb);
//            this.color = color;
        } else {
            color = null;
        }
        ;
        return "origin=" + getOrigin() + ",color=" + colorConvert + ",end="
            + end;
    };
}
