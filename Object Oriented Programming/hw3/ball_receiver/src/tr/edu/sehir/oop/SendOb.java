package tr.edu.sehir.oop;

import java.awt.*;
import java.io.Serializable;

public class SendOb implements Serializable  {

    Color color;
    float x, y, radius;
    int speed;
    float degree;// Ball's speed per step in x and y (package access)

    public SendOb(float x, float y, float radius, int speed,float degree, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = speed;
        this.degree = degree;
        this.color = color;

    }
}
