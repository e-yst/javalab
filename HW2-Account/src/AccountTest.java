import java.util.Scanner;

/**
 * Created by Eason Tse on 18/3/2017.
 */
public class AccountTest {
    public static void main(String[] args) {
        String keyin;
        Account userAccount = new Account();

        do {
            Scanner input = new Scanner(System.in);
            keyin = null;

            System.out.println("*** Main Menu ***");
            System.out.println("1) 開戶");
            System.out.println("2) 存款");
            System.out.println("3) 提款");
            System.out.println("4) 目前餘額");
            System.out.println("0) 離開");
            System.out.println();

            System.out.printf("Please enter a number in [1,2,3,4,0]: ");
            keyin = input.next();
            Integer userChoice;

            try {
                userChoice = Integer.parseInt(keyin);
            } catch (Exception NumberFormatException) {
                userChoice = null;
                continue;
            }

            Double bal;

            switch (userChoice) {
                case 1:
                    userAccount.createAccount();
                    break;
                case 2:
                    userAccount.deposit();
                    break;
                case 3:
                    userAccount.withdrawl();
                    break;
                case 4:
                    userAccount.printBalance();
                    break;
            }
            
        } while (!keyin.equals("0"));
    }
}
