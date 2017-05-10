/**
 * Created by Eason Tse on 17/4/2017.
 */
public class TicTacToe {
    private Character mark, winner;
    private Character[][] board = new Character[3][3];
    protected boolean gameOver, isFull;

    public void initGame() {
        mark = 'X';
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        gameOver = false;
        isFull = false;

        System.out.println("********** Game Start **********");
    }

    public Character getMark() {
        return mark;
    }

    public void setBoard(int row, int col) {
        board[row][col] = mark;
    }

    public void switchMark() {
        if (mark == 'X')
            mark = 'O';
        else
            mark = 'X';
    }

    public void printboard() {
        System.out.printf(" %c | %c | %c %n", board[0][0], board[0][1], board[0][2]);
        System.out.println("-----------");
        System.out.printf(" %c | %c | %c %n", board[1][0], board[1][1], board[1][2]);
        System.out.println("-----------");
        System.out.printf(" %c | %c | %c %n", board[2][0], board[2][1], board[2][2]);
    }

    public void checkResult() {
        if (checkRow() || checkCol() || checkDiagonals())
            gameOver = true;

        if (boardIsFull()) {
            gameOver = true;
            isFull = true;
        }
    }

    private boolean checkRow() {
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2]) &&
                    (board[i][0] != ' ' && board[i][1] != ' ' && board[i][2] != ' ')) {
                winner = board[i][0];
                return true;
            }
        }
        return false;
    }

    private boolean checkCol() {
        for (int i = 0; i < board.length; i++) {
            if ((board[0][i] == board[1][i] && board[0][i] == board[2][i]) &&
                    (board[0][i] != ' ' && board[1][i] != ' ' && board[2][i] != ' ')) {
                winner = board[0][i];
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2]) &&
                (board[0][0] != ' ' && board[1][1] != ' ' && board[2][2] != ' ')) {
            winner = board[1][1];
            return true;
        } else if ((board[0][2] == board[1][1] && board[0][2] == board[2][0]) &&
                (board[0][2] != ' ' && board[1][1] != ' ' && board[2][0] != ' ')) {
            winner = board[1][1];
            return true;
        }
        return false;
    }

    private boolean boardIsFull() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        return true;
    }

    public boolean inputIsValid(String txt) {
        boolean formatIsGood = txt.matches("[1-3],[1-3]");
        Integer locRow, locCol;

        if (formatIsGood) {
            locRow = Integer.parseInt(txt.split(",")[0]) - 1;
            locCol = Integer.parseInt(txt.split(",")[1]) - 1;
        } else {
            System.out.println("The value you entered is invalid! Please try again.");
            return false;
        }


        if (locIsValid(locRow, locCol))
            return true;

        System.out.println("The value you entered is invalid! Please try again.");
        return false;
    }

    private boolean locIsValid(int row, int col) {
        if (board[row][col] == ' ')
            return true;
        return false;
    }
}
