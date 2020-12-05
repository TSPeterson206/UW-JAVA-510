package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

/**
 * The GeoShape class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoShape class determines the origin point of the generated shape. It
 * contains x and y coordinates and the fill color for the shape. It also
 * contains setters and getters for these two attributes. This class
 * encapsulates functionality common to all shapes in the geo_shape package. It
 * is also an abstract class.
 * 
 * @author Toby Peterson.
 */
public abstract class GeoShape {

    /**
     * Origin. The x- and y- coordinates of the start of the shape. This
     * property may never be null.
     */
    private GeoPoint origin = new GeoPoint(0, 0);

    /**
     * Color. The fill color of the shape.
     */
    private Color color;

    /**
     * edgeColor. The edge color of the shape.
     */
    private Color edgeColor;

    /**
     * edgeWidth. The edge width of the shape.
     */
    private double edgeWidth = 1;

    /**
     * DEFAULT_COLOR. The default fill color assigned to the shape.
     */
    public final static Color DEFAULT_COLOR = Color.BLUE;

    /**
     * DEFAULT_EDGE_COLOR. The default edge color assigned to the shape.
     */
    public final static Color DEFAULT_EDGE_COLOR = Color.BLACK;

    /**
     * DEFAULT_EDGE_WIDTH. The default edge width assigned to the shape.
     */
    public final static double DEFAULT_EDGE_WIDTH = 1;

    /**
     * DEFAULT_ORIGIN. The default origin point assigned to the shape.
     */
    public final static GeoPoint DEFAULT_ORIGIN = new GeoPoint(0, 0);

    /**
     * The sole constructor for Geoshape. It contains two parameters and throws
     * a NullPointerException if the origin parameter is null.
     * 
     * @param origin The startig point of the shape to be implemented. May not
     *               be null.
     * @param color  The assigned fill color of the shape to be implemented.
     * @throws NullPointerException The origin argument of this constructor may
     *                              not be null and this exception will be
     *                              thrown if it is.
     */
    GeoShape(GeoPoint origin, Color color) throws NullPointerException {
        if (origin == null) {
            throw new NullPointerException();
        } else {
            setOrigin(origin);
        }
        setColor(color);
    };

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
     * @param origin The origin to set.
     * @throws NullPointerException of the submitted origin is null.
     */
    public void setOrigin(GeoPoint origin) throws NullPointerException {
//        System.out.println("setOrigin: " + origin);
        if (origin == null) {
            throw new NullPointerException(
                "Life is about substance2. This can't be null.");
        }
        ;
        this.origin = origin;

    }

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

        String edgeColorConvert = null;
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
        return bldr.toString();
    }

    /**
     * The getEdgeColor getter for GeoShape. Returns the edge color of this
     * shape
     * 
     * @return The edgeColor assigned to the edgeColor field in the GeoShape
     *         class.
     */
    public Color getEdgeColor() {
        return edgeColor;
    }

    /**
     * The setEdgeColor setter for GeoShape. It sets the edge color of this
     * shape.
     * 
     * @param edgeColor The edge color of this shape.
     */
    public void setEdgeColor(Color edgeColor) {
        if (edgeColor == null) {
            this.edgeColor = null;
        } else {
            this.edgeColor = edgeColor;
        }
    }

    /**
     * The getEdgeWidth getter for GeoShape. Returns the edge width of this
     * shape
     * 
     * @return The edgeWidth assigned to the edgeWidth field in the GeoShape
     *         class.
     */
    public double getEdgeWidth() {
        return this.edgeWidth;
    }

    /**
     * The setEdgeWidth setter for GeoShape. It sets the edge width of this
     * shape.
     * 
     * @param edgeWidth The edge width of this shape.
     */
    public void setEdgeWidth(double edgeWidth) {
        this.edgeWidth = edgeWidth;

    };

    /**
     * The draw method for GeoShape. This method is used to draw the given shape
     * on a GeoPlane eventually.
     * 
     * @param gtx The context to use for drawing this shape.
     */
    public abstract void draw(Graphics2D gtx);

    /**
     * The draw(2 params) method for GeoShape. It uses the given graphics
     * context to draw and/or fill the given shape.
     * 
     * @param shape The given shape.
     * @param gtx   The graphical parameters to be applied to the given shape.
     */
    public void draw(Shape shape, Graphics2D gtx) {
        System.out.println(
            "hitting super draw: " + shape + "hash: " + shape.hashCode());
//        Rectangle2D bounds = shape.getBounds2D();
//        System.out.println(bounds);
//        gtx.setColor(shape);
        System.out.println("*********************");
        gtx.fill(shape);
        gtx.draw(shape);

//        Ellipse2D oval = new Ellipse2D.Double(50, 50, 100, 200);
//        gtx.setColor(Color.GREEN);
//        gtx.fill(oval);
//        gtx.setColor(Color.BLACK);
//        gtx.setStroke(new BasicStroke(4));
//        gtx.draw(oval);

//        gtx.draw(shape);

//        if (getColor() != null) {
//            gtx.fill(shape);
//        }
//        ;
//        if (getEdgeColor() != null && getEdgeWidth() > 0) {
//            gtx.draw(shape);
//        }
//        ;
    }
//    Uses the given graphics context to draw and/or fill the given shape. It operates according to the following instructions:
//    If the color property is not null, fill the shape using gtx.fill( Shape ).
//    If the edgeColor property is not null, and the edgeWidth is greater than 0, draw the edge of the shape using gtx.draw( Shape ).

    /**
     * The commonPropertiesEqual method for GeoShape. This determines whether
     * the encapsulated object and a given object have identical property
     * values. It return true if so and false if not.
     * 
     * @param other The object being passed in for comparison.
     * @return boolean The value indicating if the properties are equal and the
     *         passed in object is not null.
     */
    public boolean commonPropertiesEqual(GeoShape other) {
        if (other == null) {
            return false;
        }

        if ((getOrigin() == other.getOrigin())
            && (getColor() == other.getColor())
            && (getEdgeColor() == other.getEdgeColor())
            && (getEdgeWidth() == other.getEdgeWidth())

        ) {
            return true;
        } else {
            return false;
        }

    }
//    Returns true if a given GeoShape object is not null and the properties it has in common with this object are equal. The common properties are:
//    origin
//    color
//    edgeColor
//    edgeWidth
//    other
//    The given GeoShape; may be null.
//
//    Returns:
//    True if a given GeoShape object is not null and the properties it has in common with this object are equal
}
