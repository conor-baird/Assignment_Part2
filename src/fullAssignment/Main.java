package fullAssignment;

import fullAssignment.Model.Cars;
import fullAssignment.Model.Roads;
import fullAssignment.Model.TrafficLight;
import fullAssignment.View.MainFrame;


import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame("Traffic Simulator");
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        Cars cars = new Cars();
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton initialise = new JButton("Initialise");
        JMenuItem Load = new JMenuItem("Load");
        JMenuItem Save = new JMenuItem("Save");
        file.add(Load);
        file.add(Save);
        menuBar.add(file);
        menuBar.add(start);
        menuBar.add(stop);
        menuBar.add(initialise);

        MainFrame mainFrame = new MainFrame();
        TrafficLight trafficLight = new TrafficLight();
        frame.add(mainFrame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        mainFrame.setButtonListener(event -> {
            Roads road = (Roads) event.getSource();
            int position = road.getNumber();
            mainFrame.updateRoad(position);
            cars.roadsChosen(position);
        });

        start.addActionListener(event ->{

            mainFrame.removeAllButtons();
            if (trafficLight.operatorLight().equals("Green")) {
                //System.out.println("Shit going");
                mainFrame.updateCar(cars.carMovement());
            }
            else{
                //System.out.println("Shit Stopped");
            }
        });

        initialise.addActionListener(event ->{
            cars.displayRoads();
            cars.setOriginalPos();
            mainFrame.updateCar((cars.setOriginalPos()));
        });


        stop.addActionListener(event ->{
            mainFrame.state = false;
        });

        Load.addActionListener(event -> {
            try {
                String text = Files.readString(Paths.get("road.csv"));
                Scanner sc = new Scanner(text);
                while (sc.hasNextLine()) {
                    System.out.println(Integer.parseInt(sc.nextLine()));
/*                    mainFrame.updateRoad(Integer.parseInt(sc.nextLine()));
                    cars.roadsChosen(Integer.parseInt(sc.nextLine()));*/
                }

        } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        Save.addActionListener(event -> {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("road.csv"));
                for (int i = 0; i < cars.roadsOutput().size(); ++i){
                    writer.println(cars.roadsOutput().get(i));
                }
                writer.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }




}
