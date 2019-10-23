package view;

import javax.swing.*;

public class NumberedButton extends JButton {
    private int number;
    public NumberedButton() {
        super();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
