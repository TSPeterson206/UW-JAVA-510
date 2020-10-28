package cp510.assignments.geo_shape;

public class GeoPoint {

    double xco = 0.0000;
    double yco = 0.0000;

    public GeoPoint() {

        this.xco = xco;
    };

    public double getXco() {
        return xco;
    };

    public void setXco(double xco) {
        this.xco = xco;
    };

    public double getYco() {
        return yco;
    };

    public void setYco(double yco) {
        this.yco = yco;
    };

    public double distance(GeoPoint other) {
        return xco;
    };

    public String toString() {
        return "(" + xco + "," + yco + ")";
    };
}
