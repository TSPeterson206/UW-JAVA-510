package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoLine extends GeoShape {

    GeoPoint end;
//    The end of the line.

    String colorConvert;

    public void setColor(Color color) {
        if (color != null) {
            int argb = color.getRGB();
            int rgb = argb & 0x00FFFFFF;
            this.colorConvert = String.format("#%06X", rgb);
        }
        ;
    };

    public GeoPoint getEnd() {
        return end;
    };

    public void setEnd(GeoPoint end) {
        this.end = end;
    };

    public double getStart() {
        return 0;
    };

    public void setStart(GeoPoint start) {
    };

    public double length() {
        return 0;
    };

    public String toString() {
        return "origin=" + origin + ",color=" + colorConvert + ",end=" + end;
    };
}
