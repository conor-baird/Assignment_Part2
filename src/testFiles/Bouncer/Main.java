package testFiles.Bouncer;

import testFiles.Bouncer.model.Rectangle;
import testFiles.Bouncer.model.Shape;
import view.Display;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {

        final int DISPLAY_WIDTH = 600;
        final int DISPLAY_HEIGHT = 480;
        final int SHAPE_COUNT = 100;

        // setup model objects
        Shape[] shapes = new Shape[SHAPE_COUNT];
        for (int i = 0; i < shapes.length; ++i) {
            int x = random.nextInt(DISPLAY_WIDTH);
            int y = random.nextInt(DISPLAY_HEIGHT);
            int width = randomSize(10, 50);
            int height = randomSize(20, 40);
            Color color = randomColor();
            shapes[i] = new Rectangle(x, y, width, height, color);
        }

        // setup view objects
        JFrame mainFrame = new JFrame("Bouncer");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Display display = new Display(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        display.setShapes(shapes);

        mainFrame.add(display, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        display.animate();
    }

    private static int randomSize(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private static Color randomColor() {
        int red = randomSize(0, 255);
        int green = randomSize(0, 255);
        int blue = randomSize(0, 255);
        int alpha = randomSize(100, 255);

        return new Color(red, green, blue, alpha);
    }
}
