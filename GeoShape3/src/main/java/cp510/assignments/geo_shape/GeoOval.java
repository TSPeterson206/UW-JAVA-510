package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Objects;

/**
 * The GeoOval class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoOval class extends the GeoRectangle class. It contains methods to
 * calculate the area and perimeter values of a given oval. This class
 * encapsulates an oval. Its only properties are inherited from its
 * superclasses.
 * 
 * @author Toby Peterson.
 */
public class GeoOval extends GeoRectangle {

    /**
     * The constructor (2 parameters) for the GeoOval class. It sets the width
     * and height of this oval to the given values. Sets the origin and color
     * properties to the defaults (DEFAULT_ORIGIN and DEFAULT_COLOR).
     * 
     * @param width  The width of the instantiated oval.
     * @param height The height of the instantiated oval.
     */
    public GeoOval(double width, double height) {
        this(DEFAULT_ORIGIN, DEFAULT_COLOR, width, height);
//        setWidth(width);
//        setHeight(height);
//        setOrigin(DEFAULT_ORIGIN);
//        setColor(DEFAULT_COLOR);

    };

    /**
     * The constructor (3 parameters) for the GeoOval class. It sets the origin,
     * width and height of this oval to the given values. Sets the color
     * property to the default (DEFAULT_COLOR).
     * 
     * @param width  The width of the instantiated oval.
     * @param height The height of the instantiated oval.
     * @param origin The origin point for the instantiated oval.
     */
    public GeoOval(GeoPoint origin, double width, double height) {
        this(origin, DEFAULT_COLOR, width, height);
//        setWidth(width);
//        setHeight(height);
//        setOrigin(origin);
//        setColor(DEFAULT_COLOR);
    };

    /**
     * The constructor (4 parameters) for the GeoOval class. It sets the color,
     * origin, width and height of this oval to the given values.
     * 
     * @param width  The width of the instantiated oval.
     * @param height The height of the instantiated oval.
     * @param origin The origin point for the instantiated oval.
     * @param color  The fill color of the instantiated oval.
     */
    public GeoOval(GeoPoint origin, Color color, double width, double height) {
        super(origin, color, width, height);
        setOrigin(origin);
        setColor(color);
        setWidth(width);
        setHeight(height);
    };

    /**
     * The area calculation method for GeoOval.
     * 
     * Returns the approximate area of this oval.
     * 
     * @return double The area value of a given oval.
     */
    public double area() {
        double halfWidth = getWidth() / 2;
        double halfHeight = getHeight() / 2;
        return halfWidth * halfHeight * Math.PI;
    };

    /**
     * The perimeter calculation method for GeoOval.
     * 
     * Returns the approximate perimeter of this oval.
     * 
     * @return double The perimeter value of a given oval.
     */
    public double perimeter() {
        double w = getWidth();
        double h = getHeight();
        return (double) 2 * Math.PI * Math.sqrt(((w * w) + (h * h)) / 2);
    };

    /**
     * The toString method for the GeoOval class. It outputs a human-readable
     * string.
     */
    public String toString() {

//        System.out
//            .println("colorConvert: " + colorConvert + " ,color: " + color);
        if (getColor() != null) {
//            System.out.println("hitting yes color" + color);
            int argb = getColor().getRGB();
            int rgb = argb & 0x00FFFFFF;
            colorConvert = String.format("#%06X", rgb);
//            this.color = color;
        } else {
//            System.out.println("hitting no color" + color);
//            color = null;
            colorConvert = null;
        }
        ;

        String edgeColorConvert = null;
        if (getEdgeColor() != null) {
            int argb = getEdgeColor().getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }
        ;

        StringBuilder bldr = new StringBuilder();
        bldr.append("origin=").append(getOrigin()).append(",color=")
            .append(colorConvert).append(",edgeColor=").append(edgeColorConvert)
            .append(",edgeWidth=")
            .append(String.format("%05.4f", getEdgeWidth())).append(",width=")
            .append(String.format("%05.4f", getWidth())).append(",height=")
            .append(String.format("%05.4f", getHeight()));
        return bldr.toString();
    };

    /**
     * The draw method for GeoOval. This method is used to draw the given shape
     * on a GeoPlane eventually.
     * 
     * @param gtx The context to use for drawing this shape.
     */
    public void draw(Graphics2D gtx) {
//        System.out.println("Drawing Oval: " + toString());
        Ellipse2D oval = new Ellipse2D.Double();
        super.draw(oval, gtx);
    };

    public boolean equals(Object other) {
        boolean result = false;
        if (other == null)
            result = false;
        else if (this == other)
            result = true;
        else if (this.getClass() != other.getClass())
            result = false;
        else {
            GeoOval that = (GeoOval) other;
            if (this.getWidth() != that.getWidth())
                ;
            else if (this.getHeight() != that.getHeight())
                ;
            else if (this.getOrigin() != that.getOrigin())
                ;
            else if (this.getColor() != that.getColor())
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
//    Returns true if a given object is equal to this object. The given object is equal to this object if:
//    It is not null;
//    It is a GeoOval;
//    All corresponding properties in the GeoShape superclass are equal; and
//    The corresponding width and height properties are equal.
//    See also: Equals/HashCode Methods, commonPropertiesEqual(GeoShape)
//    other
//    The given object.
//
//    Returns:
//    True if a given object is equal to this object.

    public int hashCode() {
        int hash = Objects.hash(getOrigin(), getColor(), getWidth(),
            getHeight());
        return hash;
    }
//    Calculates and returns a hashcode for this object.
//    Returns:
//    A hashcode for this object.

}
