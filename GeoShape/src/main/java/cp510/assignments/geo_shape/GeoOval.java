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

    public GeoOval(double width, double height) {
        this(origin, color, width, height);
        this.width = width;
        this.height = height;
        this.origin = DEFAULT_ORIGIN;
        this.color = DEFAULT_COLOR;
    };
//    Sets the width and height of this oval to the given values. Sets the origin and color properties to the defaults (DEFAULT_ORIGIN and DEFAULT_COLOR). It is required that this constructor chains to the four-parameter constructor.
//    width
//    The given width.
//
//    height
//    The given height.

    public GeoOval(GeoPoint origin, double width, double height) {
        this(origin, color, width, height);
        this.width = width;
        this.height = height;
        this.origin = origin;
        this.color = DEFAULT_COLOR;
    };
//    Sets the origin, width and height of this oval to the given values. Sets the color property to the default (DEFAULT_COLOR). It is required that this constructor chains to the four-parameter constructor.
//    origin
//    The given origin.
//
//    width
//    The given width.
//
//    height
//    The given height.

    public GeoOval(GeoPoint origin, Color color, double width, double height) {
        super(origin, color, width, height);
        this.origin = origin == null ? DEFAULT_ORIGIN : origin;
        this.color = color == null ? DEFAULT_COLOR : color;
        this.width = width;
        this.height = height;
    };

//    Sets the origin, color, width and height of this oval to the given values. 
//    origin
//    The given origin.
//
//    color
//    The given color.
//
//    width
//    The given width.
//
//    height
//    The given height.
    /**
     * The area calculation method for GeoOval.
     * 
     * Returns the approximate area of this oval.
     * 
     * @return double The area value of a given oval.
     */
    public double area() {
        // Currently a stub
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

    public String toString() {

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

        String edgeColorConvert = null;
        if (edgeColor != null) {
            int argb = edgeColor.getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }
        ;

        StringBuilder bldr = new StringBuilder();
        bldr.append("origin=").append(origin).append(",color=")
            .append(colorConvert).append(",edgeColor=").append(edgeColorConvert)
            .append(",edgeWidth=").append(String.format("%05.4f", edgeWidth))
            .append(",width=").append(String.format("%05.4f", width))
            .append(",height=").append(String.format("%05.4f", height));
        // origin=(0.0000,0.0000),color=#0000FF,edgeColor=null,edgeWidth=1.0000,width=15.3246,height=71.0575
        return bldr.toString();
    };

    public void draw(Graphics2D gtx) {
        System.out.println("Drawing Oval: " + toString());
    };
}
