import java.util.Scanner;

/**
 * Created by Eason Tse on 17/4/2017.
 */
public class GameLauncher {
    public static void main(String[] args) {

        boolean replay;
        Scanner input = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        String keyInLocation, keyInReplay;
        Integer keyInRow, keyInCol;

        do {
            game.initGame();
            do {
                game.printboard();

                do {
                    System.out.printf("Player-%c, enter your move (row[1-3],column[1-3]): ", game.getMark());
                    keyInLocation = input.nextLine();
                } while (!game.inputIsValid(keyInLocation));

                keyInRow = Integer.parseInt(keyInLocation.split(",")[0]) - 1;
                keyInCol = Integer.parseInt(keyInLocation.split(",")[1]) - 1;

                game.setBoard(keyInRow, keyInCol);
                game.checkResult();
                game.switchMark();
            } while (!game.gameOver);

            System.out.println("********** Game Over **********");
            if (game.isFull) {
                System.out.println("It's a Draw!");
            } else {
                game.switchMark();
                System.out.printf("Player-%c is the winner!%n", game.getMark());
            }

            do {
                System.out.print("Play again (Y/N)? ");
                keyInReplay = input.nextLine();
            } while (!keyInReplay.matches("[YNyn]"));

            if (keyInReplay.toLowerCase().equals("y"))
                replay = true;
            else
                replay = false;

        } while (replay);
    }
}
