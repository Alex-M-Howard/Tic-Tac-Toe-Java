import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    private TicTacToeGame game;

    TicTacToeFrame(TicTacToeGame game) {
        this.game = game;
        setWindowConfig();
        createGameTitle();
        createGameBoard();
        this.setVisible(true);
    }

    void setWindowConfig() {
        this.setTitle("Tic-Tac-Toe");
        this.setSize(800, 600);
        this.setResizable(true); // Enable resizing
        this.setLayout(new BorderLayout()); // Change to BorderLayout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255, 255, 255));
    }

    void createGameTitle() {
        JLabel label = new JLabel();
        label.setText("TIC-TAC-TOE");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Roboto", Font.BOLD, 35));
        this.add(label, BorderLayout.NORTH); // Add label to the North region of BorderLayout
    }

    void createGameBoard() {
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(3, 3));
        gameBoard.setBorder(new LineBorder(Color.BLACK, 1));

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("");
            button.setFont(new Font("Roboto", Font.BOLD, 100));
            button.setBorder(new LineBorder(Color.BLACK, 1));

            int finalI = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    int row = finalI / 3;
                    int col = finalI % 3;
                    game.makeMove(row, col);
                }
            });

            gameBoard.add(button);
        }
        this.add(gameBoard, BorderLayout.CENTER); // Add gameBoard to the Center region of BorderLayout
    }
}
