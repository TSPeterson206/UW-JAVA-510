package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

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
     * @param width
     * @param height
     */
    public GeoOval(double width, double height) {
        this(DEFAULT_ORIGIN, DEFAULT_COLOR, width, height);
//        System.out.println("hitting oval 2 params");
        setWidth(width);
        setHeight(height);
//        this.origin = DEFAULT_ORIGIN;
        setOrigin(DEFAULT_ORIGIN);
//        color = DEFAULT_COLOR;
        setColor(DEFAULT_COLOR);

    };

    /**
     * The constructor (3 parameters) for the GeoOval class. It sets the origin,
     * width and height of this oval to the given values. Sets the color
     * property to the default (DEFAULT_COLOR).
     * 
     * @param width
     * @param height
     * @param origin
     */
    public GeoOval(GeoPoint origin, double width, double height) {
        this(origin, null, width, height);
//        System.out.println("hitting oval 3 params");
        setWidth(width);
        setHeight(height);
//        this.origin = origin;
        setOrigin(origin);
        setColor(DEFAULT_COLOR);
    };

    /**
     * The constructor (4 parameters) for the GeoOval class. It sets the color,
     * origin, width and height of this oval to the given values.
     * 
     * @param width
     * @param height
     * @param origin
     * @param color
     */
    public GeoOval(GeoPoint origin, Color color, double width, double height) {
        super(origin, color, width, height);
//        System.out.println("hitting oval 4 params" + color);

//        this.origin = origin == null ? DEFAULT_ORIGIN : origin;
        setOrigin(origin);
//        this.color = color;
        setColor(color);
//        System.out.println("hitting oval 4 params" + color);

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
        return 0.00;
    };

    /**
     * The perimeter calculation method for GeoOval.
     * 
     * Returns the approximate perimeter of this oval.
     * 
     * @return double The perimeter value of a given oval.
     */
    public double perimeter() {
        // Currently a stub.
        return 0.00;
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
        System.out.println("Drawing Oval: " + toString());
    };
}
