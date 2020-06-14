import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

public class View {

    private static final int BOARD_SIZE = 9;
    private static final JButton solveButton = new JButton("Solve");
    private static final JButton resetButton = new JButton("Reset");
    private static final Font font = new Font("Verdana", Font.BOLD, 40);

    private static JFrame frame = new JFrame();;
    private static JPanel mainPanel = new JPanel(new BorderLayout());
    private static JPanel subPanel1 = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
    private static JPanel subPanel2 = new JPanel();

    private static JTextField[][] textBoard = new JTextField[BOARD_SIZE][BOARD_SIZE];



    /* --- Constructor --- */
    View(int[][] board)
    {
        // Build frame
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // build subPanel1
        subPanel1.setPreferredSize(new Dimension(500, 500));

        // Setup initial board to be editable
        populateBoard(board, true);

        // Add buttons to subPanel2
        subPanel2.add(solveButton);
        subPanel2.add(resetButton);

        // Add subPanels to mainPanel
        mainPanel.add(subPanel1, BorderLayout.CENTER);
        mainPanel.add(subPanel2, BorderLayout.PAGE_END);

        // Add mainPanel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }


    /* --- Getters  --- */

    public static JButton getSolveButton()
    {
        return solveButton;
    }

    public static JButton getResetButton()
    {
        return resetButton;
    }

    public JTextField[][] getTextBoard() {
        return textBoard;
    }

    /****************************************************************
    Function: populateBoard
    Parameters: int[][], boolean
    Description: This function takes the integer array representation
                 of the Sudoku board and places it in the view.  The
                 boolean determines if the text is editable or not.
    ****************************************************************/
    public static void populateBoard(int[][] board, boolean edit)
    {
        for (int row = 0; row < BOARD_SIZE; ++row)
            {
                for (int column = 0; column < BOARD_SIZE; ++column)
                    {
                        textBoard[row][column] = new JTextField();

                        // sync text with the board
                        textBoard[row][column].setText("" + board[row][column]);

                        textBoard[row][column].setEditable(edit);
                        textBoard[row][column].setFont(font);
                        textBoard[row][column].setHorizontalAlignment(JTextField.CENTER);

                        // update board
                        subPanel1.add(textBoard[row][column]);
                    }
            }
    }
}
