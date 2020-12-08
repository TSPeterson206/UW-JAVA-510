package cp510.assignments.geo_shape;

import java.awt.Color;

/**
 * 
 * @author toby
 *
 */
public class DrawingOvalsRectanglesLines {
    private double xOffset = 50;
    private double yOffset = 50;
    private double areaWidth = 400;
    private double areaHeight = areaWidth;
    private double width = .333 * areaWidth;
    private double height = .25 * areaHeight;
    private double edgeWidth = 4;
    private double oWidth = width - 2 * edgeWidth;
    private double oHeight = height - 2 * edgeWidth;
    private GeoPlane plane;

    private GeoPoint nwCorner = new GeoPoint(xOffset, yOffset);
    private GeoPoint neCorner = new GeoPoint(xOffset + areaWidth, yOffset);
    private GeoPoint seCorner = new GeoPoint(xOffset + areaWidth,
        yOffset + areaHeight);
    private GeoPoint swCorner = new GeoPoint(xOffset, yOffset + areaHeight);

    private double westRectX = xOffset;
    private double westRectY = areaHeight / 2;
    private GeoPoint westRectOr = new GeoPoint(westRectX, westRectY);

    private double eastRectX = areaWidth + xOffset - width;
    private double eastRectY = westRectY;
    private GeoPoint eastRectOr = new GeoPoint(eastRectX, eastRectY);

    private double northRectX = areaWidth / 2 - width / 2 + xOffset;
    private double northRectY = yOffset;
    private GeoPoint northRectOr = new GeoPoint(northRectX, northRectY);

    private double westOvalX = westRectX + edgeWidth;
    private double westOvalY = westRectY + edgeWidth;
    private GeoPoint westOvalOr = new GeoPoint(westOvalX, westOvalY);

    private double eastOvalX = eastRectX + edgeWidth;
    private double eastOvalY = eastRectY + edgeWidth;
    private GeoPoint eastOvalOr = new GeoPoint(eastOvalX, eastOvalY);

    private double northOvalX = northRectX + edgeWidth;
    private double northOvalY = northRectY + edgeWidth;
    private GeoPoint northOvalOr = new GeoPoint(northOvalX, northOvalY);

    public static void main(String[] args) {
        new Figures().execute();
    }

    public DrawingOvalsRectanglesLines() {
        this(new GeoPlane());
    }

    public DrawingOvalsRectanglesLines(GeoPlane plane) {
        this.plane = plane;
    }

    public void execute() {
        guides();
        cross();
        westRect();
        eastRect();
        northRect();

        westOval();
        eastOval();
        northOval();
        plane.show();
    }

    private void guides() {
        Color color = Color.WHITE;
        GeoRectangle rect = new GeoRectangle(nwCorner, areaWidth, areaHeight);
        rect.setColor(null);
        rect.setEdgeColor(color);
        rect.setEdgeWidth(1);
        plane.addShape(rect);

        double xco = xOffset + areaWidth / 2;
        double yco = yOffset;
        GeoPoint start = new GeoPoint(xco, yco);

        yco = yOffset + areaHeight;
        GeoPoint end = new GeoPoint(xco, yco);
        plane.addShape(new GeoLine(start, end, color, 1));

        xco = xOffset;
        yco = yOffset + areaHeight / 2;
        start = new GeoPoint(xco, yco);

        xco = xOffset + areaWidth;
        end = new GeoPoint(xco, yco);
        plane.addShape(new GeoLine(start, end, color, 1));
    }

    private void cross() {
        plane.addShape(new GeoLine(nwCorner, seCorner, Color.GREEN, 1));
        plane.addShape(new GeoLine(swCorner, neCorner, Color.YELLOW, 1));
    }

    private void westRect() {
        GeoRectangle rect = new GeoRectangle(westRectOr, Color.CYAN, width,
            height);
        rect.setEdgeColor(null);
        plane.addShape(rect);
    }

    private void eastRect() {
        GeoRectangle rect = new GeoRectangle(eastRectOr, Color.YELLOW, width,
            height);
        rect.setEdgeColor(Color.RED);
        rect.setEdgeWidth(edgeWidth);
        plane.addShape(rect);
    }

    private void northRect() {
        GeoRectangle rect = new GeoRectangle(northRectOr, null, width, height);
        rect.setEdgeColor(Color.YELLOW);
        rect.setEdgeWidth(1);
        plane.addShape(rect);
    }

    private void westOval() {
        GeoOval oval = new GeoOval(westOvalOr, Color.RED, oWidth, oHeight);
        oval.setEdgeColor(null);
        plane.addShape(oval);
    }

    private void eastOval() {
        GeoOval oval = new GeoOval(eastOvalOr, null, oWidth, oHeight);
        oval.setEdgeColor(Color.MAGENTA);
        oval.setEdgeWidth(edgeWidth);
        plane.addShape(oval);
    }

    private void northOval() {
        GeoOval oval = new GeoOval(northOvalOr, Color.ORANGE, oWidth, oHeight);
        oval.setEdgeColor(Color.CYAN);
        oval.setEdgeWidth(edgeWidth);
        plane.addShape(oval);
    }
}