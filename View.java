



public class View {

    private static JTextField[][] text;
    private static JButton button;

    public static void drawBoard() {
        JFrame frame = new JFrame();
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel subpanel1 = new JPanel(new GridLayout(9, 9));
        subpanel1.setPreferredSize(new Dimension(500,500));

        text = new JTextField[9][9];
        Font font = new Font("Verdana", Font.BOLD, 40);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                text[i][j] = new JTextField();
                text[i][j].setText("0");
                text[i][j].setEditable(true);
                text[i][j].setFont(font);
                text[i][j].setHorizontalAlignment(JTextField.CENTER);

                subpanel1.add(text[i][j]);
            }
        }

        JPanel subpanel2 = new JPanel();

        // Create listener on button press call solver
        button = new JButton("OK");
        button.addActionListener(Controller::solveBoard);

        subpanel2.add(button);
        panel.add(subpanel1, BorderLayout.CENTER);
        panel.add(subpanel2, BorderLayout.PAGE_END);

        frame.add(panel);
        frame.setVisible(true);
    }
}
