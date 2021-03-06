package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

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
     * @param width
     * @param height
     */
    public GeoRectangle(double width, double height) {
        this(DEFAULT_ORIGIN, DEFAULT_COLOR, width, height);

//        super(DEFAULT_ORIGIN, DEFAULT_COLOR);
        this.width = width;
        this.height = height;
        setOrigin(DEFAULT_ORIGIN);
//        this.color = DEFAULT_COLOR;
        setColor(DEFAULT_COLOR);

    }

    /**
     * The constructor (3 parameters) for the GeoRectangle class. It sets the
     * origin, width and height of this rectangle to the given values. It also
     * sets the color property to the default value (DEFAULT_COLOR)
     * 
     * @param width
     * @param height
     * @param origin
     */
    public GeoRectangle(GeoPoint origin, double width, double height) {
        this(origin, DEFAULT_COLOR, width, height);
        this.width = width;
        this.height = height;
//        this.origin = origin;
        setOrigin(origin);
//        this.color = DEFAULT_COLOR;
        setColor(DEFAULT_COLOR);

    }

    /**
     * The constructor (4 parameters) for the GeoRectangle class. It sets the
     * origin, color, width and height of this rectangle to the given values.
     * 
     * @param width
     * @param height
     * @param origin
     * @param color
     */
    public GeoRectangle(GeoPoint origin, Color color, double width,
        double height) {
        super(DEFAULT_ORIGIN, DEFAULT_COLOR);
        this.width = width;
        this.height = height;
//        this.origin = origin;
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
        return width * height;
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
    public void draw(Graphics2D gtx) {
        System.out.println("Drawing Rectangle: " + toString());
    }

}
