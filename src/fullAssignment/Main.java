package fullAssignment;

import fullAssignment.Model.Roads;
import fullAssignment.View.MainFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {
    private static boolean state = true;



    public static void main(String[] args){
        JFrame frame = new JFrame("Traffic Simulator");
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        JMenu operation = new JMenu("Operation");
        JMenuItem start = new JMenuItem("Start");
        JMenuItem stop = new JMenuItem("Stop");
        JMenuItem Load = new JMenuItem("Load");
        JMenuItem Save = new JMenuItem("Save");
        operation.add(start);
        operation.add(stop);
        file.add(Load);
        file.add(Save);
        menuBar.add(file);
        menuBar.add(start);
        menuBar.add(stop);




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

        start.addActionListener(event -> {
            while(state==true) {
                mainFrame.time = mainFrame.time + 1;
                System.out.println(mainFrame.time);

            }


        });

        stop.addActionListener(event ->{
            state = false;
        });







    }
}
