package fullAssignment.View;



import fullAssignment.Model.Roads;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel {
    private Roads[] buttons;
    public int time = 0;
    public boolean state;


    public MainFrame() {
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(4, 4));
        buttons = new Roads[16];
        Font font = new Font("Arial", Font.BOLD, 24);
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new Roads();
            buttons[i].setNumber(i);
            add(buttons[i]);
        }
    }

    public void setButtonListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }

    public void update(int position) {
        buttons[position].setBackground(Color.RED);

        invalidate();
    }

    public void time(){
        time += 1;
        System.out.println(time);



    }




}