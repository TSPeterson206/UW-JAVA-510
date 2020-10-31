package cp510.assignments.geo_shape;

public class GeoPoint {

    /**
     * The GeoPoint class for UW java 510 assignment 4 (GeoShape part 1).
     * 
     * The GeoPoint class contains the getters and setters for the x and y
     * coordinates, as well as a method to determine the distance between the
     * two inputed points.
     * 
     * @author Toby Peterson.
     */

    double xco;
    double yco;
    String xcoConvert;
    String ycoConvert;

    /**
     * GeoPoint constructor.
     * 
     * The constructor to initiate an instance of GeoPoint.
     */

    public GeoPoint() {
    };

    /**
     * The getxCo getter.
     * 
     * @return The GeoPoint x coordinate.
     */
    public double getXco() {
        return this.xco;
    };

    /**
     * The setXco setter.
     * 
     * Sets the x coordinate for the GeoPoint object.
     */

    public void setXco(double xco) {
        this.xco = xco;
    };

    /**
     * The getYco getter.
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
     * 
     * @param other
     * @return double The distance between this point and the given point.
     */

    public double distance(GeoPoint other) {
        return xco;
    };

    /**
     * The toString method for GeoShape
     * 
     * @return A human readable string of the origin and color values for the
     *         generated shape.
     */
    public String toString() {
//        System.out.println("xorycois0" + xco + "'" + yco);
//        if (xco == 0.0000 || yco == 0.0000) {
//            System.out.println("xorycois0");
//            xcoConvert = String.format("%05.4f", xco);
//            ycoConvert = String.format("%05.4f", xco);
//
//            return "(" + xcoConvert + "," + ycoConvert + ")";
//        }
        return "(" + xco + "," + yco + ")";
    };
}
