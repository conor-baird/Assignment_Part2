package testFiles.Bouncer.model;

import java.awt.*;
import java.util.Random;

public abstract class Shape {
    int x, y;
    Color color;
    int xDir, yDir;
    int xSpeed, ySpeed;
    private final static Random random = new Random();

    Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;

        xDir = randomDirection();
        yDir = randomDirection();
        xSpeed = randomSpeed();
        ySpeed = randomSpeed();
    }

    private static int randomDirection() {
        return random.nextBoolean() ? -1 : 1;
    }

    static int randomSpeed() {
        return random.nextInt(10) + 1;
    }

    public void move() {
        x += xSpeed * xDir;
        y += ySpeed * yDir;
    }

    public abstract void update(int boundaryWidth, int boundaryHeight);

    public abstract void draw(Graphics g);
}
