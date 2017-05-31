/**
 * Created by eason.tse on 31/5/2017.
 */
public class Point {
    private double x; // x 座標
    private double y; // y 座標

    // 建構子 (x, y)
    public Point(double x, double y) {
        this.x = x; // set x
        this.y = y; // set y
    }

    // 取得 x 座標
    public double getX() {
        return x;
    }

    // 取得 y 座標
    public double getY() {
        return y;
    }

    // 取得 Point 的 string 格式
    public String toString() {
        return String.format("(%.1f, %.1f)", getX(), getY());
    }
}