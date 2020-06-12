import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SudokuSolver {

    private static View view;

    public static void main(String[] args) {
        view = new View();
        view.run();
        //        SwingUtilities.invokeLater(new View());
    }
}
