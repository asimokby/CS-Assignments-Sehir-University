package tr.edu.sehir.oop;

import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
@author Hock-Chuan Chua
        * @version 31 October 2010
*game thread is declared as a separate class not inner class
* modified by e gul
*/
public class gameThread extends Thread {
    BallWorld bw;
    int updaterate;
    Server server;
    Thread t;
    boolean iHaveIt = true; //a boolean variable that is set true when the ball is in the window
    Client client = new Client("10.52.3.115"); // initializing a connection to the server

    public gameThread(BallWorld bw , int updaterate) throws UnknownHostException {   // constructor
        this.bw = bw;
        this.updaterate =updaterate;

        this.server = new Server();
        this.server.startServer();
        t = new Thread(this.server);
        t.start();

    }
    public void run() {
        while (true) {

            // if a Ball is received, meaning receivedObject is not null, received ball is called.
            if (ClientWorker.receivedObject != null) {
                recieve_ball();
                iHaveIt = true;
                ClientWorker.receivedObject = null;
                bw.gameUpdate();
                bw.repaint();
            }

            //if ball hits right side and was earlier reflected, it is send
            else if (Ball.wasRefrected && hitRightSide()) {
                send_ball();
                iHaveIt = false;
                Ball.wasRefrected = false;
                t = new Thread(this.server);
                t.start();
            }
            //if the ball in the screen, repaint and move it
            else if (iHaveIt) {
                bw.gameUpdate();
                // Refresh the display
                bw.repaint();
            }
//             Delay and give other thread a chance
            try {
                Thread.sleep(1000 / updaterate);
            } catch (InterruptedException ex) {

            }
        }
    }

    //create an object with the captured attributes and send it to the client
    public void send_ball(){
        try {
            SendOb objectToSend = new SendOb(bw.ball.x, bw.ball.y, bw.ball.radius, bw.speed, bw.ball.getMoveAngle(),Color.BLUE);
            client.startClient(objectToSend);
//            System.out.println("Sent: ");
//            System.out.println(objectToSend.x);
//            System.out.println(objectToSend.y);
//            System.out.println(objectToSend.degree);
            bw.ball = null;
            bw.gameUpdate();
            bw.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // the ball of the BallWorld is assigned to a new created object with the received attributes
    public void recieve_ball(){
//        System.out.println(ClientWorker.receivedObject);
//        System.out.println("Recieve: ");
//        System.out.println(ClientWorker.receivedObject.x);
//        System.out.println(ClientWorker.receivedObject.y);
//        System.out.println(ClientWorker.receivedObject.radius);
//        System.out.println(ClientWorker.receivedObject.speed);
//        System.out.println(ClientWorker.receivedObject.degree);
//        System.out.println(ClientWorker.receivedObject.color);
        bw.ball = new Ball(bw.box.maxX , ClientWorker.receivedObject.y, ClientWorker.receivedObject.radius, ClientWorker.receivedObject.speed, ClientWorker.receivedObject.degree, ClientWorker.receivedObject.color);

    }

    //check if the ball hit the right side
    public boolean hitRightSide(){
        if (bw.ball == null){
            return false;
        }
        if (this.bw.ball.x >= ( (2 * bw.ball.radius) + bw.box.maxX ) )  {
            return true;
        }
        return false;
    }

}
