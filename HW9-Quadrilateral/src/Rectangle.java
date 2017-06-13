/**
 * Created by eason.tse on 31/5/2017.
 */
public class Rectangle extends Quadrilateral {
    public Rectangle(double x1, double y1, double x2, double y2,
                     double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    // 取得矩形長
    public double getHeight() {
        if (getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint2().getY() - getPoint3().getY());
        else
            return Math.abs(getPoint1().getY() - getPoint2().getY());
    }

    // 取得矩形寬
    public double getWidth() {
        if (getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint1().getX() - getPoint2().getX());
        else
            return Math.abs(getPoint2().getX() - getPoint3().getX());
    }

    // 取得矩形面積
    public double getArea() {
        return getWidth() * getHeight();
    }

    // 取得 Rectangle 物件的 string 格式
    public String toString() {
        return String.format("Coordinates of Rectangle are:\n%s\nWidth is: %s\nHeight is: %s\nArea is: %s",
                getCoordinatesAsString(), getWidth(), getHeight(), getArea());
    }
}
