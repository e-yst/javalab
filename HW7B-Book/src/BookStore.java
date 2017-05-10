import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eason.tse on 10/5/2017.
 */
public class BookStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyInOption, userName, userPhone;
        Integer userSelection, userQuantity;
        BookOrder orders = new BookOrder();


        printMenu();
        do {
            userSelection = getBookSelection();
            userQuantity = getBookQuantity();

            orders.setOrderQty(userSelection,
                    orders.getOrderQty(userSelection) + userQuantity);

            do {
                System.out.print("繼續訂購嗎 (Y/N): ");
                keyInOption = input.nextLine().toUpperCase();
            } while (!keyInOption.matches("[YN]"));


        } while (keyInOption.equals("Y"));

        userName = getName();
        userPhone = getPhone();
        orders.setCustomerName(userName);
        orders.setPhoneNum(userPhone);

        orders.printOrder();
    }

    public static void printMenu() {
        System.out.println("********** Welcome to Book Store **********");
        for (Book book : Book.values()) {
            System.out.printf("%d) %s\t\t%.2f 元\n",
                    book.getId(), book.getName(), book.getPrice());
        }
        System.out.println();
    }

    public static Integer getBookSelection() {
        Scanner input = new Scanner(System.in);
        String keyInBookSelection;
        Integer userSelection = 0;
        boolean largerThanMax, zeroOrNegative, isValid;

        do {
            System.out.print("請輸入要訂購的書籍 [1-6]: ");
            keyInBookSelection = input.nextLine();

            if (keyInBookSelection.matches("[1-6]")) {
                userSelection = Integer.parseInt(keyInBookSelection);

                largerThanMax = userSelection > Book.values().length;
                zeroOrNegative = userSelection <= 0;
                isValid = !largerThanMax && !zeroOrNegative;
            } else {
                isValid = false;
            }

            if (!isValid)
                System.out.println("請輸入正確書籍代碼!");
        } while (!isValid);

        return userSelection;
    }

    public static Integer getBookQuantity() {

        Scanner input = new Scanner(System.in);
        String keyInQuantity;
        Integer userQuantity = 0;

        do {
            System.out.print("數量: ");
            keyInQuantity = input.nextLine();

            if (keyInQuantity.matches("\\d+"))
                userQuantity = Integer.parseInt(keyInQuantity);
            else
                System.out.println("請輸入數量!");
        } while (!keyInQuantity.matches("\\d+"));

        return userQuantity;
    }

    public static String getName() {
        Scanner input = new Scanner(System.in);
        String keyInName = "";

        do {
            System.out.print("請輸入您的姓名: ");
            keyInName = input.nextLine();
            if (!keyInName.matches("[^ ][^0-9!-\\/:-@\\[-`{-~]+$"))
                System.out.println("請輸入正確姓名!");
        } while (!keyInName.matches("[^ ][^0-9!-\\/:-@\\[-`{-~]+$"));

        return keyInName;
    }

    public static String getPhone() {
        Scanner input = new Scanner(System.in);
        String keyInPhone = "";

        do {
            System.out.print("請輸入聯絡電話: ");
            keyInPhone = input.nextLine();
            if (!keyInPhone.matches("[0-9]{4}-[0-9]{6}"))
                System.out.println("電話格式有誤! (格式: 0000-000000)");
        } while (!keyInPhone.matches("[0-9]{4}-[0-9]{6}"));
        return keyInPhone;
    }
}
