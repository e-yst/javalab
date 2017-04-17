import java.util.Scanner;

/**
 * Created by eason on 22/3/2017.
 */
public class TimeToolTest {
    public static void main(String[] args) {
        String keyin;
        Integer option;
        do {
            Scanner input = new Scanner(System.in);

            System.out.println("*** Main Menu ***");
            System.out.println("1) Show The Current Time");
            System.out.println("2) Leap Year");
            System.out.println("3) Show the Calendar");
            System.out.println("0) Exit");
            System.out.println();
            System.out.print("Please enter a number in [1,2,3,0]: ");
            keyin = input.nextLine();
            try {
                option = Integer.parseInt(keyin);
            } catch (Exception NumberFormatException) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (option) {
                case 1:
                    TimeTool.showCurrentTime();
                    break;
                case 2:
                    System.out.print("Please enter the number of year: ");
                    Integer year = input.nextInt();
                    if (TimeTool.isLeapYear(year))
                        System.out.println(year + " is a leap year.");
                    else
                        System.out.println(year + " is not a leap year.");
                    break;
                case 3:
                    System.out.print("Year: ");
                    Integer keyInYear = input.nextInt();
                    System.out.print("Month: ");
                    Integer keyInMonth = input.nextInt();

                    TimeTool.showCalendar(keyInYear, keyInMonth);
            }


        } while (!keyin.equals("0"));
    }
}