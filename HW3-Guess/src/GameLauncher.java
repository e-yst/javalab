import java.util.Scanner;

/**
 * Created by Eason Tse on 28/3/2017.
 */
public class GameLauncher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Guess game = new Guess();
        String replay;

        do {
            game.gameSetup();
            while (!game.isEnded) {
                game.rangeAndGuess();
            }
            game.endGame();

            do {
                System.out.println("******** 再玩一次(Y/N)? ********");
                replay = input.nextLine().toUpperCase();
            } while (!replay.equals("Y") && !replay.equals("N"));
        } while (replay.equals("Y"));
    }
}
