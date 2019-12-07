package com.company;

import javax.swing.*;
import java.awt.*;

public class SquareBall extends Ball {
    Color color;

    public SquareBall(int x, int y, float speed, int radius, float angleInDegree, Color color) {
        super.radius = radius;
        super.x = x;
        super.y = y;
        this.color = color;
        super.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        super.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));

    }

        public void draw(Graphics g){
            g.setColor(Color.green);
            g.drawRect((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int) (2 *radius));
        }

}
