package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import uw.syp.java.tools.GWindow;
import uw.syp.java.tools.GWindowUser;

/**
 * The GeoPlane class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoPlane class handles the adding and removal of shapes. It has methods
 * to add and remove shapes, as well as setters and getters for background
 * color.
 * 
 * @author Toby Peterson.
 */
public class GeoPlane implements GWindowUser {

    Color backgroundColor;

    List<GeoShape> geoList = new ArrayList<GeoShape>();
//    Contains a list of GeoShape objects to be drawn on the plane.

    GWindow gWindow;

    public GeoPlane() {
        backgroundColor = new Color(.5f, .5f, .5f);
    }
//    Default constructor; sets the background color to medium gray (new Color(.5F,.5F,.fF)).

    public GeoPlane(Color color) {
        this.backgroundColor = color;
    }
//    Sets the background color to a given color.
//    color
//    The given color.

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
        geoList.add(shape);
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
//        return null;
        if (geoList.contains(shape)) {
            geoList.remove(shape);
            return shape;
        } else {
            return null;
        }
        // Currently a stub.
    };

    public List<GeoShape> getShapes() {
        return geoList;
    };

    /**
     * The redraw method for GeoPlane.
     * 
     * Explicitly draws the shapes in the list of shapes. Calling this method
     * has no effect if the plane is not visible.
     * 
     * @param gtx
     */
    public void redraw(Graphics2D gtx) {
        // Currently a stub.
//        GWindowUser.redraw()
//        redraw(gtx);
        gWindow.repaint();
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

    public void redraw() {
//        gWindow.repaint();
    };
}
