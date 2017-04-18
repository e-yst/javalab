import java.util.Scanner;

/**
 * Created by Eason Tse on 17/4/2017.
 */
public class IDChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyInOption, keyInId, keyInDist, keyInGender;

        do {
            ID IdTxt = new ID();
            printMenu();

            do {
                System.out.print("請選擇: ");
                keyInOption = input.nextLine();
            } while (!keyInOption.matches("[012]"));

            switch (keyInOption) {
                case "1":
                    System.out.printf("%n請輸入身分證字號: ");
                    keyInId = input.nextLine();

                    IdTxt.newId(keyInId);
                    IdTxt.validate();
                    break;
                case "2":
                    do {
                        System.out.print("請輸入縣市: ");
                        keyInDist = IdTxt.distToNum(input.nextLine());
                    } while (keyInDist == null);

                    do {
                        System.out.print("請輸入性別: ");
                        keyInGender = IdTxt.genderToNum(input.nextLine());
                    } while (keyInGender == null);

                    String result = IdTxt.genId(keyInDist, keyInGender);
                    System.out.printf("產生的身份證字號為: %s%n", result);
                    IdTxt.validate();
                    break;
            }

        } while (!keyInOption.equals("0"));
    }

    private static void printMenu() {
        System.out.println("***********************");
        System.out.println("1.    驗證身份證字號");
        System.out.println("2.    產生身份證字號");
        System.out.println("0.    離開");
        System.out.println("***********************");
    }
}
