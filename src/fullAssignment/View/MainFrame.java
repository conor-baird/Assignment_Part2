package fullAssignment.View;



import fullAssignment.Model.Roads;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel {
    private int carButtonX;
    private int carButtonY;
    //private int time;
    private int roadButtonX;
    private int roadButtonY;
    private Roads[] buttons;
    public boolean state;


    public MainFrame() {
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(4, 4));
        buttons = new Roads[16];
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

    public void updateCar(int position){
        carButtonX = buttons[position].getX();
        carButtonY = buttons[position].getY();
        repaint();
    }

    public void updateRoad(int position) {
        buttons[position].setVisible(false);
        roadButtonX = buttons[position].getX();
        roadButtonY = buttons[position].getY();
        repaint();
    }

    public void removeAllButtons(){
        for (Roads button : buttons) {
            button.setVisible(false);
        }
    }






    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(carButtonX,carButtonY,37,37);
        g.setColor(Color.RED);
        g.fillRect(roadButtonX,roadButtonY,75,75);
    }

    /*public void timerMethod(boolean test){
        while (test==true){
            time +=1;
            System.out.println(time);
        }
    }*/






}