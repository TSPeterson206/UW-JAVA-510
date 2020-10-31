package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoPlane {
    /**
     * The GeoPlane class for UW java 510 assignment 4 (GeoShape part 1).
     * 
     * The GeoPlane class handles the adding and removal of shapes. It has
     * methods to add and remove shapes, as well as setters and getters for
     * background color.
     * 
     * @author Toby Peterson.
     */

    Color backgroundColor = new Color(.5f, .5f, .5f);

    /**
     * The show method for GeoPlane.
     */
    public void show() {
    };

    /**
     * The addShape method for GeoPlane.
     * 
     * @param shape A GeoShape object to help with adding a shape.
     */

    public void addShape(GeoShape shape) {
    };

    /**
     * 
     * @param shape The shape to remove.
     * @return The GeoShape object needing removal.
     */

    public GeoShape removeShape(GeoShape shape) {
        return shape;
    };

    /**
     * The redraw method for GeoPlane.
     * 
     * This method allows for redrawing/refreshing of a shape.
     */

    public void redraw() {
    };

    /**
     * The getBackgroundColor getter method for GeoPlane.
     * 
     * @return Color The given background color for the object.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    };

    /**
     * The setBackgroundColor setter for GeoPlane.
     * 
     * @param color The background color to set for the shape.
     */
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    };
}
