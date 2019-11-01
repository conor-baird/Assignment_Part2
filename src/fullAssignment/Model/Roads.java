package fullAssignment.Model;

import javax.swing.*;

public class Roads extends JButton {
    private int number;
    // This initialisation method just returns the roads number and sets and get it
    public Roads() {
            super();
        }
        public void setNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

}
