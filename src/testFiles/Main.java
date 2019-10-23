package testFiles;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // the view
        JFrame frame = new JFrame("Path demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        file.add(load);
        file.add(save);

        menuBar.add(file);

        JTextArea textArea = new JTextArea();
        frame.add(textArea);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // controller logic
        load.addActionListener(event -> {
            try {
                String text = Files.readString(Paths.get("data.txt"));
                textArea.setText(text);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        save.addActionListener(event -> {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("data.txt"));
                writer.print(textArea.getText());
                writer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
