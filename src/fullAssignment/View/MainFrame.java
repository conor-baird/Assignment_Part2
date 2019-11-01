package fullAssignment.View;
import fullAssignment.Model.Roads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel {
    private int carButtonX;
    private int carButtonY;
    private int roadButtonX;
    private int roadButtonY;
    private Roads[] buttons;
    public boolean state;

    // The initializer method set up the buttons array and assigns them to this array
    // in this circumstance the panel is 300 pixels wide and long with a button
    // grid layout of a 4 x 4 in the next iteration of this program the gridlayout should be adjustable
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

    // This method sets up the action listener method for each button
    public void setButtonListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }

    // This method uses the buttons position in the grid layout and uses that to find is pixel position
    // and then draw a  black box in its place representing the car
    public void updateCar(int position){
        carButtonX = buttons[position].getX();
        carButtonY = buttons[position].getY();
        repaint();
    }

    // The update road method uses a buttons position and hides the button and paints a red box the same size
    // as the button in its position using the buttons grid layout to find it x and y pixel coordinates.
    public void updateRoad(int position) {
        buttons[position].setVisible(false);
        roadButtonX = buttons[position].getX();
        roadButtonY = buttons[position].getY();
        repaint();
    }

    // This method removes all of the buttons in array list
    public void removeAllButtons(){
        for (Roads button : buttons) {
            button.setVisible(false);
        }
    }

    // this method paints the car and road.
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(carButtonX,carButtonY,37,37);
        g.setColor(Color.RED);
        g.fillRect(roadButtonX,roadButtonY,75,75);
    }








}