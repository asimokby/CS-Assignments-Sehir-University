package tr.edu.sehir.oop;

import java.awt.*;
import java.io.Serializable;

//A Class "SendOb": created to encapsulate the attributes of the ball.
//The class implements Serializable interface to be able to send the object over a stream
public class SendOb implements Serializable  {
    Color color;
    float x, y, radius;
    int speed; // Ball's speed per step in x and y (package access)
    float degree;
    public SendOb(float x, float y, float radius, int speed, float degree,  Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = speed;
        this.degree = degree;
        this.color = color;


    }
}
