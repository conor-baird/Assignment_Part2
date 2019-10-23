package fullAssignment;

import fullAssignment.Model.Roads;
import fullAssignment.View.MainFrame;
import view.NumberedButton;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        MainFrame mainFrame = new MainFrame();
        frame.add(mainFrame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainFrame.setButtonListener(event -> {
            Roads road = (Roads) event.getSource();
            int position = road.getNumber();
            mainFrame.update(position);

        });
    }
}
