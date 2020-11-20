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

    double width;
    double height;
    String colorConvert;

    /**
     * GeoRectangle constructor.
     * 
     * The constructor to initiate an instance of GeoRectangle.
     */

//    public GeoRectangle() {
//    }

    public GeoRectangle(double width, double height) {
        this(origin, color, width, height);

//        super(DEFAULT_ORIGIN, DEFAULT_COLOR);
        this.width = width;
        this.height = height;
        this.origin = DEFAULT_ORIGIN;
        this.color = DEFAULT_COLOR;
    }

    public GeoRectangle(GeoPoint origin, double width, double height) {
        this(origin, color, width, height);

//        super(DEFAULT_ORIGIN, DEFAULT_COLOR);
        this.width = width;
        this.height = height;
        this.origin = origin;
        this.color = DEFAULT_COLOR;
    }

    public GeoRectangle(GeoPoint origin, Color color, double width,
        double height) {
        super(DEFAULT_ORIGIN, DEFAULT_COLOR);
        this.width = width;
        this.height = height;
        this.origin = origin;
        this.edgeColor = DEFAULT_EDGE_COLOR;
        setColor(color);
    }

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
        this.color = color;
    };

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
//        System.out.println("color in rectangle" + color);
//        String edgeColorConvert = null;
        if (edgeColor != null) {
            int argb = edgeColor.getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }
        ;
        return "origin=" + origin + ",color=" + colorConvert + ",edgeColor="
            + edgeColorConvert + ",edgeWidth="
            + String.format("%05.4f", edgeWidth) + ",width="
            + String.format("%05.4f", width) + ",height="
            + String.format("%05.4f", height);
    };

    public void draw(Graphics2D gtx) {
        System.out.println("Drawing Rectangle: " + toString());
    }

}
