import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.lang.System;


public class Controller {
    private static View view;
    private static Model model;
    private static final int BOARD_SIZE = 9;
    private static int[][] board;
    private static JButton solveButton;
    private static JButton resetButton;


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
    private static void setListeners()
    {
        // Listen for solve button press
        solveButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    view.getSolveButton().setEnabled(false);     // disable solveButton
                    model.solveBoard();                          // solve the board
                    view.populateBoard(model.getBoard(), false); // sync board with view
                }
            });

        // Listen for reset button press
        resetButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    view.getSolveButton().setEnabled(true);    // enable resetButton
                    model.resetBoard();                         // reset the board
                    view.populateBoard(model.getBoard(), true); // sync board with view
                }
            });
    }
}
