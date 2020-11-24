package cp510.assignments.geo_shape;

/**
 * The GeoPoint class for UW java 510 assignment 4 (GeoShape part 1).
 * 
 * The GeoPoint class contains the getters and setters for the x and y
 * coordinates, as well as a method to determine the distance between the two
 * inputed points. This class encapsulates a point on a plane.
 * 
 * @author Toby Peterson.
 */
public class GeoPoint {

    /**
     * xco. The x-coordinate of the point.
     */
    private double xco;

    /**
     * The y-coordinate of the point.
     */
    private double yco;

    /**
     * GeoPoint constructor (no parameters)
     * 
     * The constructor to initiate an instance of GeoPoint. This contructor sets
     * the x and y coordinates to 0.
     * 
     */
    public GeoPoint() {
        xco = 0.0000;
        yco = 0.0000;
    }

    /**
     * The GeoPoiont constructor (two parameters).
     * 
     * The constructor to initiate an instance of GeoPoint with the given
     * parameters. Sets the x- and y-coordinates to the given values.
     * 
     * @param xco
     * @param yco
     */
    public GeoPoint(double xco, double yco) {
        this.xco = xco;
        this.yco = yco;
    }

    /**
     * The getxCo getter.
     * 
     * Returns the x-coordinate of this point.
     * 
     * @return The GeoPoint x coordinate.
     */
    public double getXco() {
        return xco;
    };

    /**
     * The setXco setter.
     * 
     * Sets the x-coordinate of this point to a given value.
     * 
     * @param xco The given value.
     */
    public void setXco(double xco) {
        this.xco = xco;
    };

    /**
     * The getYco getter.
     * 
     * Returns the x-coordinate of this point.
     * 
     * @return The GeoPoint y coordinate.
     */
    public double getYco() {
        return yco;
    };

    /**
     * The setYco setter.
     * 
     * Sets the y coordinate for the GeoPoint object.
     */
    public void setYco(double yco) {
        this.yco = yco;
    };

    /**
     * The distance method for GeoPoint.
     * 
     * Computes the distance between this point and a given point.
     * 
     * @param other the given point.
     * @return double The distance between this point and the given point.
     */
    public double distance(GeoPoint other) {
        double otherX = other.getXco();
        double otherY = other.getYco();

        return Math
            .sqrt(Math.pow(2, (xco - otherX)) + Math.pow(2, (yco - otherY)));
    };

    /**
     * The toString method for GeoShape
     * 
     * Returns a string representing the value of this point.
     * 
     * @return A human readable string of the origin and color values for the
     *         generated shape.
     */
    public String toString() {
        return "(" + String.format("%05.4f", xco) + ","
            + String.format("%05.4f", yco) + ")";
    };
}
