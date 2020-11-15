package cp510.assignments.geo_shape;

import java.awt.Color;

/**
 * The GeoPlane class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoPlane class handles the adding and removal of shapes. It has methods
 * to add and remove shapes, as well as setters and getters for background
 * color.
 * 
 * @author Toby Peterson.
 */
public class GeoPlane {

    Color backgroundColor = new Color(.5f, .5f, .5f);

    /**
     * The show method for GeoPlane.
     * 
     * Causes the plane to become visible. Any shapes stored in the list of
     * shapes to draw will immediately be drawn.
     */
    public void show() {
        // Currently a stub.
    };

    /**
     * The addShape method for GeoPlane.
     * 
     * Add a shape to the list of shapes to be drawn on the plane. Note that the
     * shape is not immediately drawn; to force the shape to appear on the plane
     * call the redraw method.
     * 
     * @param shape A GeoShape object to help with adding a shape.
     */
    public void addShape(GeoShape shape) {
        // Currently a stub.
    };

    /**
     * The removeShape method for GeoPlane
     * 
     * Removes the given shape from the list of shapes to draw on the plane. The
     * removed shape will continue to appear on the plane until the plane is
     * redrawn. If the shape is found and removed the shape object is returned;
     * if the shape is not found null will be returned.
     * 
     * @param shape The shape to remove.
     * @return The GeoShape object needing removal.
     */
    public GeoShape removeShape(GeoShape shape) {
        return null;
        // Currently a stub.
    };

    /**
     * The redraw method for GeoPlane.
     * 
     * Explicitly draws the shapes in the list of shapes. Calling this method
     * has no effect if the plane is not visible.
     */
    public void redraw() {
        // Currently a stub.
    };

    /**
     * The getBackgroundColor getter method for GeoPlane.
     * 
     * Returns the background color of this GeoPlane.
     * 
     * @return Color The given background color for the object.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    };

    /**
     * The setBackgroundColor setter for GeoPlane.
     * 
     * Sets the background color of this GeoPlane to the given color. The
     * background color will not physically change until the plane is redrawn.
     * 
     * @param color The background color to set for the shape.
     */
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    };
}
