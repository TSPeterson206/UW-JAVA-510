package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Objects;

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

    /**
     * The ending point of the GeoLine.
     */
    private GeoPoint end;

    /**
     * The constructor (2 parameter) for the GeoLine class. It sets the start
     * and endpoints of this line to the given values. Sets the edgeColor and
     * edgeWidth properties to the defaults (DEFAULT_EDGE_COLOR and
     * DEFAULT_EDGE_WIDTH) and sets the color property to null.
     * 
     * @param start The starting coordinates of the instantiated line.
     * @param end   The ending coordinates of the instantiated line.
     * @throws NullPointerException This throws a NullPointerException if null
     *                              is passed into the start parameter.
     */
    public GeoLine(GeoPoint start, GeoPoint end) throws NullPointerException {
        this(start, end, DEFAULT_EDGE_COLOR, DEFAULT_EDGE_WIDTH);
        if (start == null) {
            throw new NullPointerException();
        }
        ;
        setStart(start);
        setColor(null);
    };

    /**
     * The constructor (3 parameter) for the GeoLine class. It sets the
     * edgeWidth, start and endpoints of this line to the given values. Sets the
     * edgeColor property to the default (DEFAULT_EDGE_COLOR) and sets the color
     * property to null.
     * 
     * @param start The starting coordinates of the instantiated line.
     * @param end   The ending coordinates of the instantiated line.
     * @param width The wdith of the instantied line.
     * @throws NullPointerException This throws a NullPointerException if null
     *                              is passed into the start parameter.
     */
    public GeoLine(GeoPoint start, GeoPoint end, double width)
        throws NullPointerException {
        this(start, end, DEFAULT_EDGE_COLOR, width);
        if (start == null) {
            throw new NullPointerException();
        }
        ;
        setColor(null);
    };

    /**
     * The constructor (3 parameter) for the GeoLine class. It sets the
     * edgeWidth, edgeColor, start and endpoints of this line to the given
     * values. It sets the color property to null.
     * 
     * @param start     The starting coordinates of the instantiated line.
     * @param end       The ending coordinates of the instantiated line.
     * @param width     The wdith of the instantied line.
     * @param edgeColor The edge color of the instantiated line.
     * @throws NullPointerException This throws a NullPointerException if null
     *                              is passed into the start parameter.
     */
    public GeoLine(GeoPoint start, GeoPoint end, Color edgeColor, double width)
        throws NullPointerException {
        super(start, edgeColor);
        if (start == null) {
            throw new NullPointerException();
        }
        ;
        setColor(null);
        setOrigin(start);
        this.end = end;
        setEdgeColor(edgeColor);
        setEdgeWidth(width);
        if (width == 0) {
            setEdgeWidth(DEFAULT_EDGE_WIDTH);
        }
    };

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
                "Life is about substance1. This can't be null.");
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
        double length = end.distance(getOrigin());
        return length;
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

        if (getEdgeColor() != null) {
            int argb = getEdgeColor().getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }
        ;

        String colorConvert = null;
        return "origin=" + getOrigin() + ",color=" + colorConvert
            + ",edgeColor=" + edgeColorConvert + ",edgeWidth="
            + String.format("%05.4f", getEdgeWidth()) + ",end=" + end;
    }

    /**
     * The draw method for GeoLine. This method is used to draw the given shape
     * on a GeoPlane eventually.
     * 
     * @param gtx The context to use for drawing this shape.
     */
    @Override
    public void draw(Graphics2D gtx) {
        double xco1 = getOrigin().getXco();
        double yco1 = getOrigin().getYco();
        double xco2 = getEnd().getXco();
        double yco2 = getEnd().getYco();

        Line2D line = new Line2D.Double(xco1, yco1, xco2, yco2);
        super.draw(line, gtx);
    };

    /**
     * The setColor method for GeoLine. This method overrides the
     * GeoShape.setColor(Color) method. It does nothing. It is present merely to
     * prevent the color property in the GeoShape class from being set to a
     * non-null value.
     */
    @Override
    public void setColor(Color color) {
    }

    /**
     * The equals method for the GeoLine class.
     * 
     * @return boolean A boolean that states whether the passed argument Object
     *         is equal to the encapsulated object.
     */
    public boolean equals(Object other) {
        boolean result = false;
        if (other == null)
            result = false;
        else if (this == other)
            result = true;
        else if (this.getClass() != other.getClass())
            result = false;
        else {
            GeoLine that = (GeoLine) other;
            if (this.end != that.end)
                ;
            else if (this.getOrigin() != that.getOrigin())
                ;
            else if (this.getEdgeColor() != that.getEdgeColor())
                ;
            else if (this.getEdgeWidth() != that.getEdgeWidth())
                ;
            else
                result = true;
        }
        return result;
    }

    /**
     * The hashCode method for the GeoLine class.
     * 
     * @return int The hashcode for the encapuslated object.
     */
    @Override
    public int hashCode() {
        int hash = Objects.hash(getOrigin(), getColor(), getStart(), getEnd());
        return hash;
    }
}
