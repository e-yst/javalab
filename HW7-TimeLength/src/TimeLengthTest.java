import java.util.Scanner;

/**
 * Created by eason.tse on 9/5/2017.
 */
public class TimeLengthTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String keyInOption, keyInTime, timeInTxt, timeInSec;
        TimeLength mTime = new TimeLength();

        do {
            printMenu();
            do {
                System.out.print("Please enter a number in [1,2,3,0]: ");
                keyInOption = input.nextLine();
            } while (!keyInOption.matches("[0-3]"));
            switch (keyInOption) {
                case "1":
                    do {
                        System.out.print("Please enter a time (seconds or hh:mm:ss): ");
                        keyInTime = input.nextLine();
                    } while (!keyInTime.matches("\\d+") &&
                            !keyInTime.matches("\\d+:[0-5]\\d:[0-5]\\d"));

                    mTime.setup(keyInTime);
                    System.out.println();
                    break;

                case "2":
                    do {
                        System.out.print("Please enter a time (seconds or hh:mm:ss): ");
                        keyInTime = input.nextLine();
                    } while (!keyInTime.matches("[+-]\\d+") &&
                            !keyInTime.matches("[+-]\\d+:[0-5]\\d:[0-5]\\d"));

                    System.out.println("Time: " + keyInTime);

                    if (keyInTime.contains("+")) {
                        mTime.addTime(keyInTime);
                    } else if (keyInTime.contains("-")){
                        mTime.minusTime(keyInTime);
                    }

                    System.out.println();
                    break;

                case "3":
                    System.out.print("The current length of time (seconds) : " + mTime.getTimeInSec() + "\n");
                    System.out.print("The current length of time (hh:mm:ss): " + mTime.getTimeInTxt() + "\n");
                    System.out.println();
                    break;

            }
        } while (!keyInOption.equals("0"));

    }

    private static void printMenu() {
        System.out.println("***Convert Length of Time***");
        System.out.println("1) Set a length of time.");
        System.out.println("2) Adjust the Length of time.");
        System.out.println("3) Show length of time in different units.");
        System.out.println("0) Exit");
    }
}
