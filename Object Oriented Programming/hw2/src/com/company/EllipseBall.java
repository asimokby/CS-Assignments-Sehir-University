package com.company;

import java.awt.*;

public class EllipseBall extends Ball{
    Color color;

    public EllipseBall(int x, int y, float speed, int radius, float angleInDegree, Color color) {
        super.radius = radius;
        super.x = x;
        super.y = y;
        this.color = color;
        super.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        super.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));

    }


    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.drawOval((int)(x - radius), (int)(y - radius), (int)(2 *  radius), (int) (radius));
    }

    public void moveOneStepWithCollisionDetection(ContainerBox box) {
        // Get the ball's bounds, offset by the radius of the ball
        int ballMinX = Math.round(box.minX + radius );
        int ballMinY = Math.round(box.minY + radius );
        int ballMaxX = Math.round(box.maxX - radius );
        int ballMaxY = Math.round(box.maxY - (radius / 2 / 2));

        // Calculate the ball's new position
        x += speedX;
        y += speedY;
        // Check if the ball moves over the bounds. If so, adjust the position and speed.
        if (x < ballMinX) {
            speedX = -speedX; // Reflect along normal
            x = ballMinX;     // Re-position the ball at the edge
        } else if (x > ballMaxX) {
            speedX = -speedX;
            x = ballMaxX;
        }
        // May cross both x and y bounds
        if (y < ballMinY) {
            speedY = -speedY;
            y = ballMinY;
        } else if (y > ballMaxY) {
            speedY = -speedY;
            y = ballMaxY;
        }
    }
}

