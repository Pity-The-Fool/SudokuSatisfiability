import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

// Debug
import java.util.Arrays;



public class Controller
{
    private static final int BOARD_SIZE = 9;
    private View view;
    private Model model;
    private JButton solveButton;
    private JButton resetButton;

    private int[][] board;


    /* --- Constructor --- */
    Controller()
    {
        // create model
        model = new Model();
        board = model.getBoard();

        // create view
        view = new View(board);
        solveButton = view.getSolveButton();
        resetButton = view.getResetButton();

        // Set listeners for the buttons on the view
        setListeners();
    }



    /****************************************************************
    Function: setListeners
    Description: Set listeners to solve the board and/or reset the
                 board and synchronize with the view
    ****************************************************************/
    private void setListeners()
    {
        // Listen for solve button press
        solveButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    view.getSolveButton().setEnabled(false);     // disable solveButton
                    convertTextToBoard(view.getTextBoard());     // get updated board
                    model.solveBoard();                          // solve the board
                    board = model.getBoard();
                    printBoard();
                    view.populateBoard(board, false); // sync board with view
                }
            });

        // Listen for reset button press
        resetButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    view.getSolveButton().setEnabled(true);     // enable resetButton
                    //convertTextToBoard(view.getTextBoard());     // get updated board
                    model.resetBoard();                         // reset the board
                    board = model.getBoard();
                    printBoard();
                    view.populateBoard(board, true); // sync board with view
                }
            });
    }

    private void convertTextToBoard(JTextField[][] textBoard)
    {
        for (int row = 0; row < BOARD_SIZE; ++row)
            {
                for (int column = 0; column < BOARD_SIZE; ++column)
                    {
                        board[row][column] = Integer.parseInt(textBoard[row][column].getText());
                    }
            }
    }

    private void printBoard() {
        System.out.println(Arrays.deepToString(board));
    }
}
