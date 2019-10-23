package view;

import testFiles.Bouncer.model.Shape;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private Shape[] shapes;
    private Timer timer;

    public Display(int width, int height) {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(width, height));
    }

    public void animate() {
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(1000/60, e -> {
            if (shapes == null) return;
            for (Shape shape : shapes) {
                shape.move();
                shape.update(getWidth(), getHeight());
            }
            repaint();
        });
        timer.start();
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            g.setColor(Color.WHITE);
            shape.draw(g);
        }
    }
}
