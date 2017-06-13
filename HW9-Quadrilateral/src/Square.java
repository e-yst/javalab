/**
 * Created by eason.tse on 31/5/2017.
 */
public class Square extends Quadrilateral{
    public Square(double x1, double y1, double x2, double y2,
                     double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    // 取得正方形邊長
    public double getLength() {
        double d = Math.sqrt(Math.pow( (getPoint1().getX() - getPoint2().getX()), 2) + Math.pow( (getPoint1().getY() - getPoint2().getY()), 2));
        return d;
    }

    // 取得正方形面積
    public double getArea() {
        return getLength() * getLength();
    }

    // 取得 Square 物件的 string 格式
    public String toString() {
        return String.format("Coordinates of Square are:\n%\nLength is: %s\nArea is: %s",
                getCoordinatesAsString(), getLength(), getArea());
    }
}
