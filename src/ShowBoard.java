import java.util.Arrays;

public class ShowBoard {
    public void showBoard() {
        String[][] board = new String[10][10];

        // Every even row
        // Every odd col
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (row % 2 == 0 && col % 2 != 0)
                    board[row][col] = "X";

                else
                    board[row][col] = "O";
            }
            for (String s : board[row]) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ShowBoard s = new ShowBoard();
        s.showBoard();
    }

}
