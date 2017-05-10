import java.util.Scanner;

/**
 * Created by Eason Tse on 28/3/2017.
 */
public class Guess {
    private int limit, max, min, answer, userGuess, index;
    protected boolean isEnded;
    private int[] gamerGuesses;

    public void gameSetup() {

        System.out.println("********** 猜數字遊戲 **********");
        do {
            min = intInputCheck("猜數字範圍最小值: ");
            max = intInputCheck("猜數字範圍最大值: ");
            if (min > max)
                System.out.println("最大最小值不正確!");
        } while (min > max);

        limit = intInputCheck("猜數字次數限制: ");
        answer = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("[DEBUG] answer: " + answer);

        gamerGuesses = new int[limit];
        for (int i = 0; i < limit; i++)
            gamerGuesses[i] = 0;

        index = 0;
        isEnded = false;

        System.out.printf("%n*********** 遊戲開始 ***********%n");
    }

    public void rangeAndGuess() {
        if (index + 1 > gamerGuesses.length) {
            isEnded = true;
            return;
        }

        System.out.printf("數字範圍: %d ~ %d%n", min, max);

        userGuess = intInputCheck("你猜的數字: ");
        while (userGuess < min || userGuess > max) {
            System.out.println("猜錯了! 您猜的數字超出答案範圍!");
            userGuess = intInputCheck("你猜的數字: ");
        }


        if (userGuess > answer) {
            System.out.println("猜錯了! 您猜的數字比答案小!");
            max = userGuess;
            gamerGuesses[index] = userGuess;
            saveAns(userGuess);
        } else if (userGuess < answer) {
            System.out.println("猜錯了! 您猜的數字比答案大!");
            min = userGuess;
            gamerGuesses[index] = userGuess;
            saveAns(userGuess);
        } else {
            System.out.println("恭喜您猜對了!");
            gamerGuesses[index] = userGuess;
            saveAns(userGuess);
            isEnded = true;
        }
    }

    public void endGame() {
        System.out.printf("*********** 遊戲結束 ***********");
        for (int i = 0; i < gamerGuesses.length; i++) {
            if (gamerGuesses[i] != 0)
                System.out.printf("%n第 %d 猜: %d", i + 1, gamerGuesses[i]);
        }
        System.out.println("\n---");
        System.out.printf("猜數字限制 %d 次%n", limit);
        System.out.printf("你共猜了 %d 次%n", index);
        System.out.printf("正確答案: %d%n", answer);
    }

    private int intInputCheck(String text) {
        boolean success = false;
        int result = 999;

        while (!success) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print(text);
                result = input.nextInt();
                success = true;

            } catch (java.util.InputMismatchException e) {
                System.out.println("請輸入數字!");
            }
        }
        return result;
    }

    private void saveAns(int n) {
        gamerGuesses[index] = n;
        if (index < gamerGuesses.length)
            index++;
    }

}
