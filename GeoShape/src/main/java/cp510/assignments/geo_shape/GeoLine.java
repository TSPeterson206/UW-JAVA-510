package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

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

    GeoPoint end;

//    private GeoPoint end = new GeoPoint(0, 0);

    public GeoLine(GeoPoint start, GeoPoint end) throws NullPointerException {
        this(start, end, DEFAULT_EDGE_COLOR, DEFAULT_EDGE_WIDTH);

//        super(DEFAULT_EDGE_COLOR, DEFAULT_EDGE_WIDTH);
        this.edgeColor = DEFAULT_EDGE_COLOR;
        this.edgeWidth = DEFAULT_EDGE_WIDTH;

    };
//    Sets the start and endpoints of this line to the given values. Sets the edgeColor and edgeWidth properties to the defaults (DEFAULT_EDGE_COLOR and DEFAULT_EDGE_WIDTH) and sets the color property to null. It is required that this constructor chains to the four-parameter constructor.
//    start
//    The given start point.
//
//    end
//    The given height.

    public GeoLine(GeoPoint start, GeoPoint end, double width)
        throws NullPointerException {
        this(start, end, DEFAULT_EDGE_COLOR, width);
        this.edgeColor = DEFAULT_EDGE_COLOR;
    };
//    Sets the start point, endpoint and edgeWidth properties of this line to the given values. Sets the edgeColor property to the default (DEFAULT_EDGE_COLOR) and sets the color property to null. It is required that this constructor chain to the four-parameter constructor.
//    start
//    The given start point.
//
//    end
//    The given endpoint.
//
//    width
//    The given edge width.

    public GeoLine(GeoPoint start, GeoPoint end, Color edgeColor, double width)
        throws NullPointerException {
        super(origin, color);
        this.color = null;
        this.start = start;
        this.end = end;
        this.edgeColor = edgeColor;
        this.edgeWidth = width;
    };
//    Sets the properties of this line to the given values; the color property is explicitly set to null.
//    start
//    The given start point.
//
//    edgeColor
//    The given edge color.
//
//    end
//    The given endpoint.
//
//    width
//    The given edge width.

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

        String edgeColorConvert = null;
        if (edgeColor != null) {
            int argb = edgeColor.getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }
        ;

        String colorConvert = null;
        if (getColor() != null) {
            int argb = this.color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            colorConvert = String.format("#%06X", rgb);
//            this.color = color;
        } else {
            color = null;
        }
        ;
        return "origin=" + getOrigin() + ",color=" + colorConvert
            + ",edgeColor=" + edgeColorConvert + ",edgeWidth=" + edgeWidth
            + ",end=" + end;
    }

    @Override
    public void draw(Graphics2D gtx) {
        // TODO Auto-generated method stub
        System.out.println("Drawing Line: " + toString());

    };

    public void setColor(Color color) {
    }
}
