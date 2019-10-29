package fullAssignment;

import fullAssignment.Model.Cars;
import fullAssignment.Model.Roads;
import fullAssignment.View.MainFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static void main(String[] args){
        JFrame frame = new JFrame("Traffic Simulator");
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        Cars cars = new Cars();
        JMenu operation = new JMenu("Operation");
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JMenuItem Load = new JMenuItem("Load");
        JMenuItem Save = new JMenuItem("Save");
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
            mainFrame.updateRoad(position);
            cars.carRoads(position);


        });

        start.addActionListener(event ->{
            mainFrame.time();
            mainFrame.updateCar(cars.carMovement());



        });
        stop.addActionListener(event ->{
            cars.displayRoads();
            cars.setOriginalPos();
            mainFrame.state = false;
        });

    }




}
