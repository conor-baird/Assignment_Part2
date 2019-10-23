import model.TicTacToe;
import view.Board;
import view.NumberedButton;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        mainFrame.add(board);
        mainFrame.pack();

        board.setButtonListener(event -> {
            NumberedButton button = (NumberedButton) event.getSource();
            int position = button.getNumber();

            if (game.placeNextPiece(position)) {
                board.update(game.getState());

                TicTacToe.Status status = game.checkStatus();
                switch (game.checkStatus()) {
                    case O_WON:
                    case X_WON:
                        board.setEnabled(false);
                        String winner = status == TicTacToe.Status.O_WON ? "O" : "X";
                        String message = String.format("Game over! %s won", winner);
                        JOptionPane.showMessageDialog(mainFrame, message);
                        break;
                    case DRAW:
                        board.setEnabled(false);
                        JOptionPane.showMessageDialog(mainFrame, "draw...");
                        break;
                }
            }
        });

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
