import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private static final int BOARD_SIZE = 9;
    private static final String fontType = "Verdana";
    private static Font font;
    private static JButton solve;
    private static JButton reset;
    private static JTextField[][] textBoard;
    private static Model model;
    private static int[][] board;

    Controller() {
        // create a model
        model = new Model();
        board = model.getBoard();

        // construct buttons
        solve = new JButton("Solve");
        reset = new JButton("Reset");

        // construct text fields
        textBoard = new JTextField[9][9];
        font = new Font(fontType, Font.BOLD, 40);

        // populate
        populateBoard(board);
    }

    private static void populateBoard(int[][] board) {
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int column = 0; column < BOARD_SIZE; ++column) {
                textBoard[row][column] = new JTextField();
                textBoard[row][column].setText(Integer.toString(board[row][column]));
                textBoard[row][column].setEditable(true);
                textBoard[row][column].setFont(font);
                textBoard[row][column].setHorizontalAlignment(JTextField.CENTER);
            }
        }
    }

    public JTextField[][] getTextBoard() {
        return textBoard;
    }

    public JButton getSolveButton() {
        return solve;
    }

    public JButton getResetButton() {
        return reset;
    }

    public static void resetBoard() {
        model.resetBoard();
        board = model.getBoard();
        populateBoard(board);
    }

    public static void solveBoard() {
        // manipulate model
    }
}
