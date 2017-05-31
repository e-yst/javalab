/**
 * Created by eason.tse on 31/5/2017.
 */
public class Quadrilateral {
    private Point point1; // first endpoint
    private Point point2; // second endpoint
    private Point point3; // third endpoint
    private Point point4; // fourth endpoint

    public Quadrilateral(double x1, double y1, double x2, double y2,
                         double x3, double y3, double x4, double y4) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        point4 = new Point(x4, y4);
    }

    @Override
    public String toString() {
        return String.format("Coordinates: %s, %s, %s, %s", point1, point2, point3, point4);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public Point getPoint4() {
        return point4;
    }
}
