package testFiles.Bouncer.model;

import java.awt.*;

public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(int boundaryWidth, int boundaryHeight) {
        if ((x - width / 2 < 0 && xDir < 0) || (x + width / 2 > boundaryWidth && xDir > 0)) {
            xDir *= -1;
            xSpeed = randomSpeed();
        }

        if ((y - height / 2 < 0 && yDir < 0) || (y + height / 2 > boundaryHeight && yDir > 0)) {
            yDir *= -1;
            ySpeed = randomSpeed();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }
}
