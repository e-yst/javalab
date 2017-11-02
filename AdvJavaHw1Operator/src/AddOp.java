public class AddOp implements Operator {
    private double x, y;
    private String x_str, y_str;

    public AddOp(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public AddOp(Operator x, Operator y) {
        this.x = x.run();
        this.y = y.run();
        x_str = x.toString();
        y_str = y.toString();
    }


    @Override
    public double run() {
        return x + y;
    }

    @Override
    public String toString() {
        if (x_str != null && y_str != null) {
            return String.format("(%s + %s)", x_str, y_str);
        } else {
            return String.format("(%d + %d)", (int) x, (int) y);
        }
    }
}
