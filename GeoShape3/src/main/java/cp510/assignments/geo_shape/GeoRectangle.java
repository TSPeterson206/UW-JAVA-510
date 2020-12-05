package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

/**
 * The GeoRectangle class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoRectangle class extends the GeoShape class. It contains the width and
 * height of a rectangle object. It contains setters and getters for height and
 * width, as well as a method to calculate the area. This class encapsulates a
 * rectangle.
 * 
 * @author Toby Peterson.
 */
public class GeoRectangle extends GeoShape {

    /**
     * width. The width of the rectangle.
     */
    private double width;

    /**
     * height. The height of the rectangle.
     */
    private double height;

    /**
     * A string containing the fill color for the rectangle in hexadecimal
     * format.
     */
    String colorConvert;

    /**
     * The constructor (2 parameters) for the GeoRectangle class. It sets the
     * width and height of this rectangle to the given values. It also sets the
     * origin and color properties to the defaults (DEFAULT_ORIGIN and
     * DEFAULT_COLOR)
     * 
     * @param width  The width of the instantiated rectangle.
     * @param height The height of the instantiated rectangle.
     */
    public GeoRectangle(double width, double height) {
        this(DEFAULT_ORIGIN, DEFAULT_COLOR, width, height);
//        this.width = width;
//        this.height = height;
//        setOrigin(DEFAULT_ORIGIN);
//        setColor(DEFAULT_COLOR);
    }

    /**
     * The constructor (3 parameters) for the GeoRectangle class. It sets the
     * origin, width and height of this rectangle to the given values. It also
     * sets the color property to the default value (DEFAULT_COLOR)
     * 
     * @param width  The width of the instantiated rectangle.
     * @param height The height of the instantiated rectangle.
     * @param origin The origin point of the instantiated rectangle.
     */
    public GeoRectangle(GeoPoint origin, double width, double height) {
        this(origin, DEFAULT_COLOR, width, height);
//        this.width = width;
//        this.height = height;
//        setOrigin(origin);
//        setColor(DEFAULT_COLOR);

    }

    /**
     * The constructor (4 parameters) for the GeoRectangle class. It sets the
     * origin, color, width and height of this rectangle to the given values.
     * 
     * @param width  The width of the instantiated rectangle.
     * @param height The height of the instantiated rectangle.
     * @param origin The origin point of the instantiated rectangle.
     * @param color  The color of the instantiated rectangle.
     */
    public GeoRectangle(GeoPoint origin, Color color, double width,
        double height) {
        super(DEFAULT_ORIGIN, DEFAULT_COLOR);
        this.width = width;
        this.height = height;
        setOrigin(origin);
        setEdgeColor(DEFAULT_EDGE_COLOR);
        setColor(color);
    }

    /**
     * The getWidth getter.
     * 
     * Returns the width of this rectangle.
     * 
     * @return double The width value of the given rectangle.
     */
    public double getWidth() {
        return width;
    };

    /**
     * The setWidth setter.
     * 
     * Sets the width of this rectangle to a given value.
     * 
     * @param width The width value of the given rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    };

    /**
     * The getHeight getter.
     * 
     * Returns the height of this rectangle.
     * 
     * @return double The height value of the given rectangle.
     */
    public double getHeight() {
        return height;
    };

    /**
     * The setHeight setter.
     * 
     * Sets the height of this rectangle to a given value.
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
     * Returns the area of this rectangle.
     * 
     * @return double The area value of the width and height multiplied.
     */
    public double area() {
        return width * height;
    };

    /**
     * The perimeter method for GeoRectangle.
     * 
     * Returns the perimeter of this rectangle.
     * 
     * @return double The perimeter value of the width and height multiplied.
     */
    public double perimeter() {

        double perimeter;

//        ellipse perimeter approx 2pi sqrt((a^2+b^2)/2)

        // formula to find the Perimeter
        // of an Ellipse.
        perimeter = (double) 2 * 3.14
            * Math.sqrt(((width * width) + (height * height)) / (2 * 1.0));

        System.out.println("Perimeter: " + perimeter);

        return perimeter;
    };

    /**
     * The toString method for GeoShape.
     * 
     * Returns a string describing the properties of this GeoRectangle.
     * 
     * @return String A human readable string of the origin, color, height, and
     *         width values for the generated shape.
     */
    public String toString() {

        String edgeColorConvert = null;
        String colorConvert = null;
        if (getColor() != null) {
            int argb = getColor().getRGB();
            int rgb = argb & 0x00FFFFFF;
            colorConvert = String.format("#%06X", rgb);
        } else {
//            color = null;
        }

        if (getEdgeColor() != null) {
            int argb = getEdgeColor().getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }
        ;
        return "origin=" + getOrigin() + ",color=" + colorConvert
            + ",edgeColor=" + edgeColorConvert + ",edgeWidth="
            + String.format("%05.4f", getEdgeWidth()) + ",width="
            + String.format("%05.4f", width) + ",height="
            + String.format("%05.4f", height);
    };

    /**
     * The draw method for GeoRectangle. This method is used to draw the given
     * shape on a GeoPlane eventually.
     * 
     * @param gtx The context to use for drawing this shape.
     */
//    public void draw(Graphics2D gtx) {
//        System.out.println("Drawing Rectangle: " + toString());
//    }

    public void draw(Graphics2D gtx) {
        Rectangle2D rect = new Rectangle2D.Double();
        super.draw(rect, gtx);
    }
//    Instantiate and initialize a Rectangle2D.Double object.
//    Pass the Rectangle2D object to the draw( Shape, Graphics2D ) method method in the GeoShape class.

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other == null)
            result = false;
        else if (this == other)
            result = true;
        else if (this.getClass() != other.getClass())
            result = false;
        else {
            GeoRectangle that = (GeoRectangle) other;
            if (this.getWidth() != that.getWidth())
                ;
            else if (this.getHeight() != that.getHeight())
                ;
            else {
                result = true;
            }
        }
        return result;
    }
//    Returns true if a given object is equal to this object. The given object is equal to this object if:
//    It is not null;
//    It is a GeoRectangle;
//    All corresponding properties in the GeoShape superclass are equal; and
//    The corresponding width and height properties are equal.
//    See also: Equals/HashCode Methods, commonPropertiesEqual(GeoShape)
//    other
//    The given object.

//    Returns:
//    True if a given object is equal to this object.

    public int hashCode() {
        int hash = Objects.hash(getOrigin(), getColor(), width, height);
        return hash;
    }
//    Calculates and returns a hashcode for this object.
//    Returns:
//    A hashcode for this object.

}
