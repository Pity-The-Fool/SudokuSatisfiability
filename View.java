import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class View {

    private static final int BOARD_SIZE = 9;
    private static JTextField[][] textBoard;
    private static JButton solve;
    private static JButton reset;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel subPanel1;
    private static JPanel subPanel2;
    private static Controller controller;


    View() {
        controller = new Controller();
        textBoard = controller.getTextBoard();
        solve = controller.getSolveButton();
        reset = controller.getResetButton();

        frame = new JFrame();
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());

        subPanel1 = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        subPanel1.setPreferredSize(new Dimension(500, 500));

        subPanel2 = new JPanel();


        for(int row = 0; row < BOARD_SIZE; ++row) {
            for(int column = 0; column < BOARD_SIZE; ++column) {
                subPanel1.add(textBoard[row][column]);
            }
        }

        subPanel2.add(solve);
        subPanel2.add(reset);
        mainPanel.add(subPanel1, BorderLayout.CENTER);
        mainPanel.add(subPanel2, BorderLayout.PAGE_END);

        frame.add(mainPanel);
        frame.setVisible(true);
    }


    public static void run() {

        // Listen for solve button press
        solve.addActionListener(controller.solveBoard);

        // Listen for reset button press
        reset.addActionListener(controller.resetBoard);
    }

    public static void updateBoard() {

    }
}
