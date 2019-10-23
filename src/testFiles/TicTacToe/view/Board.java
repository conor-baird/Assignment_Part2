package testFiles.TicTacToe.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Board extends JPanel {
    private NumberedButton[] buttons;

    public Board() {
        setPreferredSize(new Dimension(300,300));
        setLayout(new GridLayout(3,3));
        buttons = new NumberedButton[9];
        Font font = new Font("Arial", Font.BOLD, 24);
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new NumberedButton();
            buttons[i].setNumber(i);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
    }

    public void setButtonListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }

    public void update(String[] state) {
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i].setText(state[i]);
        }
        invalidate();
    }

    @Override
    public void setEnabled(boolean value) {
        super.setEnabled(value);
        for (JButton button : buttons) {
            button.setEnabled(value);
        }
    }
}
