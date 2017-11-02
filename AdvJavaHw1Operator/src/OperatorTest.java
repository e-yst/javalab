public class OperatorTest {

    public static void main(String[] args) {
        Operator myOp = new MultiplyOp(new AddOp(5, 7), new DivideOp(12, 3));
        System.out.printf("myOp.run() -> " + myOp.run());
        System.out.printf("%nmyOp is "+ myOp);
    }
}
