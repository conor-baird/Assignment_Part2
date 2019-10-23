package fullAssignment;

import fullAssignment.Model.Roads;
import fullAssignment.View.MainFrame;


import javax.swing.*;

public class Main {
    private static int time = 0;

    public static void main(String[] args){
        JFrame frame = new JFrame("Traffic Simulator");
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        JMenu start = new JMenu("Start");
        JMenu stop = new JMenu("Stop");
        JMenuItem Load = new JMenuItem("Load");
        JMenuItem Save = new JMenuItem("Save");
        JMenu currentTime = new JMenu(String.valueOf(time));
        file.add(Load);
        file.add(Save);
        menuBar.add(file);
        menuBar.add(start);
        menuBar.add(stop);
        menuBar.add(currentTime);



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
