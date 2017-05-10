import java.util.Scanner;

/**
 * Created by Eason Tse on 17/4/2017.
 */
public class IDChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyInOption, keyInId;

        do {
            printMenu();
            do {
                System.out.print("請選擇: ");
                keyInOption = input.nextLine();
            } while (!keyInOption.equals("0") && !keyInOption.equals("1"));

            System.out.printf("%n請輸入身分證字號: ");
            keyInId = input.nextLine();

            ID IdTxt = new ID(keyInId);
            IdTxt.validate();

        } while (!keyInOption.equals("0"));
    }

    private static void printMenu() {
        System.out.println("***********************");
        System.out.println("1.    驗證身份證字號");
        System.out.println("0.    離開");
        System.out.println("***********************");
    }
}
