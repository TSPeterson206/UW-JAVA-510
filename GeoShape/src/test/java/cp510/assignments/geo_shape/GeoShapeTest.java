package cp510.assignments.geo_shape;

class GeoShapeTest {

    private static GeoShape shape;
    private static GeoLine line;
    private static GeoOval oval;
    private static GeoPlane plane;
    private static GeoPoint point;
    private static GeoRectangle rectangle;

    private static double xcoValue;
    private static double ycoValue;
    private static double distance;
//    private static String pointString;
//    private static GeoPoint lineString;

//    private static String distanceString = "0.749766968903826";

//    public static void main(String[] args) {
//        shape = new GeoShape();
//        line = new GeoLine();
//        oval = new GeoOval();
//        plane = new GeoPlane();
//        point = new GeoPoint();
//        rectangle = new GeoRectangle();
////GeoPoint
//        point.setXco(5.55555);
//        point.setYco(4.44444);
//        xcoValue = point.getXco();
//        ycoValue = point.getYco();
//        distance = point.distance(point);
////        pointString = point.toString();
//// GeoShape
//        shape.setOrigin(point);
//        shape.getOrigin();
//        shape.setColor(Color.RED);
//        shape.getColor();
//        shape.toString();
//
//// GeoRectangle
//        rectangle.setWidth(1.0000);
//        rectangle.setHeight(2.0000);
//        rectangle.getWidth();
//        rectangle.getHeight();
//        rectangle.area();
//        rectangle.perimeter();
//        rectangle.setColor(Color.RED);
//        rectangle.toString();
//
//        // GeoOval
//        oval.area();
//        oval.perimeter();
//// GeoLine
//
//        line.setEnd(point);
//        line.getEnd();
//        line.setStart(point);
//        line.getStart();
//        line.length();
//        line.toString();
//        line.setColor(Color.RED);
//// GeoPlane
//        plane.show();
//        plane.addShape(shape);
//        plane.removeShape(shape);
//        plane.redraw();
//        plane.setBackgroundColor(Color.RED);
//        plane.getBackgroundColor();
//    };
//
//    // Tests GeoPoint
//
//    @Test
//    void xAndYCoordinates() {
//        point = new GeoPoint();
//
//        point.setXco(5.55555);
//        point.setYco(4.44444);
//        xcoValue = point.getXco();
//        ycoValue = point.getYco();
////        pointString = point.toString();
//
//        GeoPoint point2 = new GeoPoint();
//        point2.setXco(6.66666);
//        point2.setYco(7.77777);
//
//        Assertions.assertEquals(5.55555, xcoValue);
//        Assertions.assertEquals(4.44444, ycoValue);
//        Assertions.assertEquals("(5.5556,4.4444)", point.toString());
//        Assertions.assertEquals(0.749766968903826, point.distance(point2));
////        double result = point.distance(point2);
////        System.out.println("checking point distance" + result);
//////        assertTrue(distanceString.contains(result.toString());
//
//    }
//
//    @Test
//    void distance() {
//
//        Assertions.assertEquals(0, distance);
//    }
//
//    // Tests GeoShape class
//    @Test
//    void color() {
//        shape = new GeoShape();
//
//        point = new GeoPoint();
//
//        point.setXco(5.55555);
//        point.setYco(4.44444);
//
//        shape.setOrigin(point);
//        shape.setColor(Color.RED);
//        Assertions.assertEquals(Color.RED, shape.getColor());
//        Assertions.assertEquals("origin=(5.5556,4.4444),color=#FF0000",
//            shape.toString());
//        shape.setColor(null);
//        Assertions.assertEquals("origin=(5.5556,4.4444),color=null",
//            shape.toString());
//    }
//
//    @Test
//    void testExpectedExceptionNullOriginShape() {
//
//        shape = new GeoShape();
//        Assertions.assertThrows(NullPointerException.class, new Executable() {
//            public void execute() throws Throwable {
//                shape.setOrigin(null);
//            }
//        });
//    }
//
//    // Tests GeoLine class
//    @Test
//    void start() {
//        shape = new GeoShape();
////        shape.setColor(Color.RED);
//
//        point = new GeoPoint();
//        point.setXco(5.55555);
//        point.setYco(4.44444);
////        shape = new GeoShape();
//
//        line = new GeoLine();
//        line.setEnd(point);
//        line.setStart(point);
//        line.setColor(Color.RED);
//
////        System.out.println(point);
////        GeoPoint lineString = line.getEnd();
//
//        Assertions.assertEquals(point, line.getEnd());
//        Assertions.assertEquals(point, line.getStart());
//        Assertions.assertEquals(0, line.length());
//        Assertions.assertEquals(
//            "origin=(5.5556,4.4444),color=#FF0000,end=(5.5556,4.4444)",
//            line.toString());
//        line.setColor(null);
//        Assertions.assertEquals(
//            "origin=(5.5556,4.4444),color=null,end=(5.5556,4.4444)",
//            line.toString());
//
//    }
//
//    @Test
//    void testExpectedExceptionNullOriginLine() {
//
//        line = new GeoLine();
//        Assertions.assertThrows(NullPointerException.class, new Executable() {
//            public void execute() throws Throwable {
//                line.setEnd(null);
//            }
//        });
//    }
//
////    @Test
////    void end() {
////
////        Assertions.assertEquals(0, reg.getStart());
////    }
////
////    @Test
////    void length() {
////
////        Assertions.assertEquals(2, reg.getCount());
////    }
//
////Tests GeoOval class
//    @Test
//    void widthAndHeight() {
//        rectangle = new GeoRectangle();
//
//        rectangle.setWidth(10.1234456);
//        rectangle.setHeight(20.1234567);
//
//        oval = new GeoOval();
////        System.out.println("rectangle and oval " + rectangle + "  " + oval
////        + "zxzx" + rectangle.getHeight());
//        Assertions.assertEquals(0, oval.area());
//        Assertions.assertEquals(0, oval.perimeter());
//
////        Assertions.assertEquals(20.1234567, oval.getHeight());
//    }
//
//    // Tests GeoRectangle class
//    @Test
//    void area() {
//        rectangle = new GeoRectangle();
//
//        rectangle.setWidth(10.1234456);
//        rectangle.setHeight(20.1234567);
//        rectangle.getWidth();
//        rectangle.getHeight();
//        rectangle.area();
//        rectangle.perimeter();
//        rectangle.setColor(Color.RED);
//        rectangle.toString();
//        Assertions.assertEquals(203.7187191864055, rectangle.area());
//
//    }
//
////Tests GeoRectangle class
//    @Test
//    void height() {
////        rectangle.setWidth(50.33333);
//        rectangle = new GeoRectangle();
//
//        rectangle.setWidth(10.1234456);
//        rectangle.setHeight(20.1234567);
//
//        Assertions.assertEquals(10.1234456, rectangle.getWidth());
//        Assertions.assertEquals(20.1234567, rectangle.getHeight());
//
//    }
//
////
////    @Test
////    void perimeter() {
////
////        Assertions.assertEquals(0, reg.getSecurity());
////    }
//
////Tests GeoPlane class
//    @Test
//    void backgroundColor() {
//        shape = new GeoShape();
//
//        plane = new GeoPlane();
//        plane.show();
//        plane.addShape(shape);
//        plane.removeShape(shape);
//        plane.redraw();
//        plane.setBackgroundColor(Color.BLUE);
//        Assertions.assertEquals(Color.BLUE, plane.getBackgroundColor());
////        Assertions.assertEquals(void, plane.show());
//
//    }

}
