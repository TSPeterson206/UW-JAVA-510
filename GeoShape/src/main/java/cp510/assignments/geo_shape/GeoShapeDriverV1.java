package cp510.assignments.geo_shape;

import java.awt.Color;

public class GeoShapeDriverV1 {
    public static void main(String[] args) {
        GeoPoint point1 = new GeoPoint();
        point1.setXco(5.55555);
        ;
        point1.setYco(4.44444);

        GeoPoint point2 = new GeoPoint();
        point2.setXco(54.66666);
        point2.setYco(133.33333);

        GeoPoint point3 = new GeoPoint();
        point3.setXco(200);
        point3.setYco(400);

        GeoPoint point4 = new GeoPoint();
        point4.setXco(1000);
        point4.setYco(2000);

//        System.out.println("point1" + point1);

        GeoShape shape = new GeoShape();
        shape.setColor(null);
        System.out.println(shape);
        shape.setOrigin(point1);
        System.out.println(shape);
        shape.setColor(Color.RED);
        System.out.println(shape);

        GeoRectangle rect = new GeoRectangle();
        rect.setColor(null);
        rect.setOrigin(point2);
        rect.setWidth(50.33333);
        rect.setHeight(60.66666);
        System.out.println(rect);
        rect.setColor(Color.BLUE);
        System.out.println(rect);
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println(rect);

        GeoOval oval = new GeoOval();
        oval.setColor(null);
        oval.setOrigin(point3);
        oval.setWidth(10.1234456);
        oval.setHeight(20.1234567);
        System.out.println(oval);
        oval.setColor(Color.GREEN);
        System.out.println(oval);
        oval.setWidth(10);
        oval.setHeight(20);
        System.out.println(oval);

        GeoLine line = new GeoLine();
        line.setColor(null);
        line.setOrigin(point3);
        line.setEnd(point1);
        System.out.println(line);
        line.setColor(Color.GREEN);
        System.out.println(line);
        line.setStart(point2);
        System.out.println(line);

        System.out.println(new GeoPlane().getBackgroundColor());

        System.out.println("******** Null Point Checks *********");
        tryNullPoint(shape);
        tryNullPoint(rect);
        tryNullPoint(oval);
        tryNullPoint(line);
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
}