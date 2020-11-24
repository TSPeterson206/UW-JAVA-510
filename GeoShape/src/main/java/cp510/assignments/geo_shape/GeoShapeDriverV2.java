package cp510.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GeoShapeDriverV2 {
    private static final Random randy = new Random(1);

    public static void main(String[] args) {
        GeoPlane plane = new GeoPlane();
        Data dat = new Data();
        GeoShape shape = null;

        /* All properties set */
        shape = new GeoRectangle(dat.point1, dat.color, dat.width, dat.height);
        shape.setEdgeColor(dat.edgeColor);
        shape.setEdgeWidth(dat.edgeWidth);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2, dat.edgeColor,
            dat.edgeWidth);
        plane.addShape(shape);

        /* edgeWidth default */
        dat.next();
        shape = new GeoOval(dat.point1, dat.color, dat.width, dat.height);
        shape.setEdgeColor(dat.edgeColor);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2);
        shape.setEdgeColor(dat.edgeColor);
        plane.addShape(shape);

        /* color default */
        dat.next();
        shape = new GeoRectangle(dat.point1, dat.width, dat.height);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2, dat.edgeWidth);
        plane.addShape(shape);

        /* edgeColor default */
        dat.next();
        shape = new GeoRectangle(dat.point1, dat.color, dat.width, dat.height);
        shape.setEdgeWidth(dat.edgeWidth);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2, dat.edgeWidth);
        plane.addShape(shape);

        /* color == null */
        dat.next();
        shape = new GeoOval(dat.point1, null, dat.width, dat.height);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2, dat.edgeWidth);
        shape.setEdgeColor(null);
        plane.addShape(shape);

        /* edgeColor == null */
        dat.next();
        shape = new GeoRectangle(dat.point1, dat.color, dat.width, dat.height);
        shape.setEdgeColor(null);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2, dat.edgeWidth);
        shape.setEdgeColor(null);
        plane.addShape(shape);

        /* Default origin, color */
        dat.next();
        shape = new GeoOval(dat.width, dat.height);
        shape.setEdgeColor(null);
        plane.addShape(shape);
        shape = new GeoLine(dat.point1, dat.point2);
        shape.setEdgeColor(null);
        plane.addShape(shape);

        Graphics2D gtx = getGraphicsCtx();
        plane.redraw(gtx);

        tryNullPoint(new GeoRectangle(10, 10));
    }

    private static Graphics2D getGraphicsCtx() {
        int type = BufferedImage.TYPE_INT_ARGB;
        BufferedImage image = new BufferedImage(10, 10, type);
        Graphics2D gtx = (Graphics2D) image.createGraphics();
        return gtx;
    }

    private static void tryNullPoint(GeoShape shape) {
        String name = shape.getClass().getName();
        System.out.print(name + "... ");
        try {
            shape.setOrigin(null);
            System.out.println("failed");
        } catch (NullPointerException exc) {
            System.out.println("passed");
        }
    }

    private static double nextDouble() {
        return randy.nextDouble() * 100;
    }

//    private static double

    private static GeoPoint nextGeoPoint() {
        double xco = nextDouble();
        double yco = nextDouble();
        GeoPoint geoPoint = new GeoPoint(xco, yco);
        return geoPoint;
    }

    private static Color nextColor() {
        float red = (float) randy.nextDouble();
        float green = (float) randy.nextDouble();
        float blue = (float) randy.nextDouble();
        Color color = new Color(red, green, blue);
        return color;
    }

    private static class Data {
        public GeoPoint point1;
        public GeoPoint point2;
        public Color color;
        public double width;
        public double height;
        public Color edgeColor;
        public double edgeWidth;
        public boolean useRectShape;

        public Data() {
            next();
        }

        public void next() {
            point1 = nextGeoPoint();
            point2 = nextGeoPoint();
            ;
            color = nextColor();
            width = nextDouble();
            height = nextDouble();
            edgeColor = nextColor();
            edgeWidth = nextDouble();
            useRectShape = randy.nextBoolean();
        }
    }
}
