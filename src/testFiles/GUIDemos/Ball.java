package testFiles.GUIDemos;

import java.awt.*;

class Ball {
    private int x, y;
    private int radius;

    Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    void draw(Graphics g) {
        int topLeftX = x - radius;
        int topLeftY = y - radius;
        g.fillOval(topLeftX, topLeftY,
                2 * radius, 2 * radius);
    }

    void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
