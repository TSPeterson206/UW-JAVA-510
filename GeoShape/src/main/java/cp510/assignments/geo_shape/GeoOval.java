package cp510.assignments.geo_shape;

public class GeoOval extends GeoRectangle {

    /**
     * The GeoOval class for UW java 510 assignment 4 (GeoShape part 1).
     * 
     * The GeoOval class extends the GeoRectangle class. It contains methods to
     * calculate the area and perimeter values of a given oval.
     * 
     * @author Toby Peterson.
     */

    /**
     * The area calculation method for GeoOval.
     * 
     * @return double The area value of a given oval.
     */
    public double area() {
        return width * height;
    };

    /**
     * The perimeter calculation method for GeoOval.
     * 
     * @return double The perimeter value of a given oval.
     */
    public double perimeter() {
        return 0;
    };
}
