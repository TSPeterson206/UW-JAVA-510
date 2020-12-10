package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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

    /**
     * backgroundColor. The background color of the plane that displays the
     * given shapes. The default background color is medium-gray
     */
    private Color backgroundColor;

    /**
     * geoList. Contains a list of GeoShape objects to be drawn on the plane.
     */
    private List<GeoShape> geoList = new ArrayList<GeoShape>();

    /**
     * gWindow. The canvas on which GeoShapes will be drawn.
     */
    private GWindow gWindow;

    /**
     * The default constructor for GeoPlane. It sets the background color to
     * medium gray (new Color(.5F,.5F,.fF)).
     */
    public GeoPlane() {
        this(Color.GRAY);
        backgroundColor = new Color(.5f, .5f, .5f);
        gWindow = new GWindow(500, 500);
        gWindow.setGWindowUser(this);
    }

    /**
     * The one-parameter constructor for GeoPlane. Sets the background color to
     * a given color.
     * 
     * @param color The given color.
     */
    public GeoPlane(Color color) {
        setBackgroundColor(color);
    }

    /**
     * The show method for GeoPlane.
     * 
     * Causes the plane to become visible. Any shapes stored in the list of
     * shapes to draw will immediately be drawn.
     */
    public void show() {
        gWindow.start();
        gWindow.repaint();
    };

    /**
     * The getBitmap method for GeoPlane. Note: I have been instructed to return
     * null in this method due to issues with students calling the getBitmap
     * method on GWindow.
     * 
     * @return BufferedImage The bitmap bufferedImage of the encapsulated
     *         object.
     */
    public BufferedImage getBitmap() {
        return gWindow.getBitmap();
    }

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
        if (geoList.contains(shape)) {
            geoList.remove(shape);
            return shape;
        } else {
            return null;
        }
    };

    /**
     * The getShapes method for GeoPlane.
     * 
     * @return The list (geoList) containing the shapes to display on the plane.
     */
    public List<GeoShape> getShapes() {
        return geoList;
    };

    /**
     * The redraw (1 parameter) method for GeoPlane.
     * 
     * Calls the draw(Graphics2D) method for all shapes in the list of shapes.
     * 
     * @param gtx The graphical parameter used for draw.
     */
    public void redraw(Graphics2D gtx) {
        int width = gWindow.getWidth();
        int height = gWindow.getHeight();

        gtx.setColor(backgroundColor);
        gtx.fillRect(0, 0, width, height);

        for (GeoShape item : geoList) {
            item.draw(gtx);
        }

    };

    /**
     * The redraw (0 parameters) method. It explicitly draws the shapes in the
     * list of shapes. Calling this method has no effect if the plane is not
     * visible.
     */
    public void redraw() {
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

}
