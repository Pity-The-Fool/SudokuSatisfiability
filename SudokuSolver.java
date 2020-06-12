import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SudokuSolver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(View::drawBoard);
    }
}
