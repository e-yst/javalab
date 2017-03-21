import java.util.Scanner;

/**
 * Created by Eason Tse on 18/3/2017.
 */
public class Account {
    private Double balance;
    private boolean isCreated = false;

    public void createAccount() {

        if (isCreated) {
            System.out.println("已開戶!");
            return;
        }

        Double keyin;
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入開戶金額: ");
        try {
            keyin = input.nextDouble();
        } catch (Exception InputMismatchException) {
            System.out.println("開戶失敗! 請輸入金額!");
            return;
        }

        if (keyin < 1000)
            System.out.println("開戶失敗! 開戶金額必須大於或等於1000!");
        else {
            balance = keyin;
            isCreated = true;
            printBalance();
        }

    }

    public void deposit() {
        if (!isCreated) {
            System.out.println("未開戶!");
            return;
        }

        Double keyin;
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入存款金額: ");
        try {
            keyin = input.nextDouble();
        } catch (Exception InputMismatchException) {
            System.out.println("存款失敗! 請輸入金額!");
            return;
        }

        if (keyin < 0) {
            System.out.println("存款失敗! 請輸入非負數值!");
            return;
        } else {
            balance += keyin;
            System.out.println("成功存入 " + keyin + " 元!");
            printBalance();
        }
    }

    public void withdrawl() {
        if (!isCreated) {
            System.out.println("未開戶!");
            return;
        }

        Double keyin;
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入提款金額: ");
        try {
            keyin = input.nextDouble();
        } catch (Exception InputMismatchException) {
            System.out.println("提款失敗! 請輸入金額!");
            return;
        }

        if (keyin > balance) {
            System.out.println("提款失敗! 提款金額大於目前餘額!");
            printBalance();
            return;
        } else if (keyin < 0) {
            System.out.println("提款失敗! 請輸入非負數值!");
            return;
        } else {
            balance -= keyin;
            System.out.println("成功領出 " + keyin + " 元!");
            printBalance();
        }
    }
    public void printBalance() {
        if (!isCreated) {
            System.out.println("未開戶!");
            return;
        }

        System.out.println("目前餘額: " + balance + " 元");
    }
}
