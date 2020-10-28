package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoPlane {

    Color backgroundColor = new Color(.5f, .5f, .5f);

    public void show() {
    };

    public void addShape(GeoShape shape) {
    };

    public GeoShape removeShape(GeoShape shape) {
        return shape;
    };

    public void redraw() {
    };

    public Color getBackgroundColor() {
        return backgroundColor;
    };

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    };
}
