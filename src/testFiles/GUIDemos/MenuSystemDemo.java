package testFiles.GUIDemos;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MenuSystemDemo {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        Ball ball = new Ball(100, 100, 35);

        frame.setModel(ball);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();

                System.out.println("Mouse pressed: " + x + " " + y);
                ball.moveTo(x, y);
            }
        });

        frame.addExitActionListener(event -> System.exit(0));

        frame.addAboutActionListener(event -> JOptionPane.showMessageDialog(frame, "This is a great app you should buy it now!"));
    }
}
