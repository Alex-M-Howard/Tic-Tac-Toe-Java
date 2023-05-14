import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class TicTacToeFrame extends JFrame {
    private TicTacToeGame game;
    private List<JButton> buttons = new ArrayList<>();

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
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setText("TIC-TAC-TOE");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Roboto", Font.BOLD, 35));
        this.add(label, BorderLayout.NORTH); // Add label to the North region of BorderLayout

        JButton restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Roboto", Font.PLAIN, 20));
        northPanel.add(restartButton, BorderLayout.EAST);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                restartGame();
            }
        });

        this.add(northPanel, BorderLayout.NORTH);
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

                    if(!game.getGameOver()){
                        if (game.getCurrentPlayer() == 1){
                            button.setText("X");
                        } else {
                            button.setText("O");
                        }
                    }

                    button.setEnabled(false);
                    game.makeMove(row, col);

                    if (game.getGameOver()){
                        disableButtons();
                        List<int[]> winningLine = game.getLastWinningLine();
                        if (winningLine != null) {
                            highlightWinningLine(winningLine);
                        }
                    }
                }
            });
            buttons.add(button);
            gameBoard.add(button);
        }
        this.add(gameBoard, BorderLayout.CENTER); // Add gameBoard to the Center region of BorderLayout
    }

    void disableButtons() {
        for(JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    void highlightWinningLine(List<int[]> winningLine) {
        for (int[] pos : winningLine) {
            int index = pos[0] * 3 + pos[1];
            JButton winningButton = buttons.get(index);
            winningButton.setEnabled(true);
            winningButton.setForeground(Color.GREEN);
        }
    }

    void restartGame() {
        game = new TicTacToeGame();

        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
            button.setForeground(Color.BLACK);
        }
    }
}
