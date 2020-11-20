package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * The GeoShape class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoShape class determines the origin point of the generated shape. It
 * contains x and y coordinates and the fill color for the shape. It also
 * contains setters and getters for these two attributes. This class
 * encapsulates functionality common to all shapes in the geo_shape package.
 * 
 * @author Toby Peterson.
 */
public abstract class GeoShape {

//    private GeoPoint origin;
    public static GeoPoint origin = new GeoPoint(0, 0);
    protected static Color color;

//    private String originConvert;
    Color edgeColor;
//    The edge color of the shape.

    double edgeWidth = 1;
//    The edge width of the shape.

    static Color DEFAULT_COLOR = Color.BLUE;
    public static Color DEFAULT_EDGE_COLOR = Color.BLACK;
    static double DEFAULT_EDGE_WIDTH = 1;
    static GeoPoint DEFAULT_ORIGIN = new GeoPoint(0, 0);

    String edgeColorConvert;

    GeoShape(GeoPoint origin, Color color) throws NullPointerException {
//        if (origin == null) {
//            throw new NullPointerException();
//        } else {
//        this.origin = origin;
        setOrigin(origin);
//        }
        setColor(color);
    };
//    Sets the origin and color of the shape. Origin may not be null. If null is passed for the origin NullPointerException must be thrown.
//    origin
//    The origin of the shape. May not be null. If null is passed for the origin NullPointerException must be thrown.
//
//    color
//    The fill color of the shape (may be null).

//    /**
//     * GeoShape constructor.
//     * 
//     * The constructor to initiate an instance of GeoShape.
//     */
//    public GeoShape() {
//    };

    /**
     * The getOrigin getter.
     * 
     * Returns the origin of this shape.
     * 
     * @return The GeoPoint origin coordinates.
     */
    public GeoPoint getOrigin() {
        return this.origin;
    };

    /**
     * The setOrigin setter.
     * 
     * Sets the origin of this shape to a given value. The given value may not
     * be null. If the given value is null a NullPointerException will be
     * thrown.
     * 
     * @throws NullPointerException of the submitted origin is null.
     */
    public void setOrigin(GeoPoint origin) {
//        if (origin == null) {
//            throw new NullPointerException(
//                "Life is about substance. This can't be null.");
//        }
//        ;
        this.origin = origin;
    };

    /**
     * The getColor getter.
     * 
     * Returns the fill color of this shape.
     * 
     * @return The fill color for the generated shape.
     */
    public Color getColor() {
        return this.color;
    };

    /**
     * The setColor setter.
     * 
     * Sets the fill color of this shape to a given value. (Note: color may be
     * null.).
     * 
     * @param color The fill color of the generated shape. This is converted
     *              into a string format.
     */
    public void setColor(Color color) {
        this.color = color;
    };

    /**
     * The toString method for GeoShape
     * 
     * Returns a string describing the origin and color properties of this
     * GeoShape.
     * 
     * @return A human readable string of the origin and color values for the
     *         generated shape.
     */
    public String toString() {

        StringBuilder bldr = new StringBuilder();

        String colorConvert = null;

        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            colorConvert = String.format("#%06X", rgb);
        } else {
            color = null;
        }
        ;

        if (edgeColor != null) {
            int argb = edgeColor.getRGB();
            int rgb = argb & 0x00FFFFFF;
            edgeColorConvert = String.format("#%06X", rgb);
        }

        bldr.append("origin=").append(origin).append(",color=")
            .append(colorConvert).append(",edgeColor=").append(edgeColorConvert)
            .append(",edgeWidth=").append(edgeWidth);
//        return "origin=" + origin + ",color=" + colorConvert;
        return bldr.toString();
    }

    public Color getEdgeColor() {
        return this.edgeColor;
    }

    public void setEdgeColor(Color edgeColor) {
        // TODO Auto-generated method stub
//        System.out.println("setting edge color" + edgeColor);
        if (edgeColor == null) {
            this.edgeColor = null;
        } else {
            this.edgeColor = edgeColor;
        }
    }

    public double getEdgeWidth() {
        return this.edgeWidth;
    }

    public void setEdgeWidth(double edgeWidth) {
        // TODO Auto-generated method stub
        this.edgeWidth = edgeWidth;

    };

    public abstract void draw(Graphics2D gtx);
}
