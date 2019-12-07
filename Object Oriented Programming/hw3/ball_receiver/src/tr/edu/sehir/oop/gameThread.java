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
    Client client = new Client("10.52.3.25"); // asem's ip: "10.52.3.25"
    BallWorld bw;
    int updaterate;
    Server server;
    Thread t;
    Boolean IHaveIt = false;
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

            if (ClientWorker.receivedObject != null ){
                recieve_ball();
                IHaveIt = true;
                ClientWorker.receivedObject= null;
                bw.gameUpdate();
                bw.repaint();
            }

            else  if (Ball.wasRefrected && bw.hitLeftSide()){
                IHaveIt = false;
                send_ball();
                bw.gameUpdate();
                bw.repaint();
                t = new Thread(this.server);
                t.start();
                Ball.wasRefrected = false;

            }
            else if (IHaveIt){
                bw.gameUpdate();
                bw.repaint();
            }

            // Delay and give other thread a chance
            try {
                Thread.sleep(1000 / updaterate);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void recieve_ball() {
//        System.out.println(ClientWorker.receivedObject);
//        System.out.println("Recieve: ");
//        System.out.println(ClientWorker.receivedObject.x);
//        System.out.println(ClientWorker.receivedObject.y);
//        System.out.println(ClientWorker.receivedObject.radius);
//        System.out.println(ClientWorker.receivedObject.speed);
//        System.out.println(ClientWorker.receivedObject.degree);
//        System.out.println(ClientWorker.receivedObject.color);
        bw.ball = new Ball(0, ClientWorker.receivedObject.y, ClientWorker.receivedObject.radius, ClientWorker.receivedObject.speed, ClientWorker.receivedObject.degree, ClientWorker.receivedObject.color);
    }


    public void send_ball(){

                try {
                    SendOb objectToSend = new SendOb(bw.ball.x, bw.ball.y, bw.ball.radius, 40,bw.ball.getMoveAngle(), Color.BLUE);
                    client.startClient(objectToSend);
//                    System.out.println(objectToSend);
//                    System.out.println("Sent: ");
//                    System.out.println(objectToSend.x);
//                    System.out.println(objectToSend.y);
//                    System.out.println(objectToSend.radius);
//                    System.out.println(objectToSend.speed);
//                    System.out.println(objectToSend.degree);
                    bw.ball = null;

                } catch (IOException e) {
                    e.printStackTrace();
                }

    }

}
