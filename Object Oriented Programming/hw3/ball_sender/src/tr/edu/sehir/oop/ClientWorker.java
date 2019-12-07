package tr.edu.sehir.oop;

import java.io.*;
import java.net.Socket;

public class ClientWorker implements Runnable {
    private Socket clientSocket;
    //declaring a static variable that will capture the received attributes of the ball (encapsulated in an object)
    public static SendOb receivedObject = null;
    //Constructor
    ClientWorker(Socket client, int clientNo) {
        clientSocket = client;
        System.out.println("client number " + clientNo + " has connected to server");
    }

    public void run(){
        ObjectInputStream objectInputStream = null;
        try{

            //creating an input stream to receive the ball
            InputStream inputStream = clientSocket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

        } catch (IOException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }

        while (true) {
            SendOb ob = null; //initializing the object of the the class to be send to null
            try {
                //reading the received object from the input stream and assigning it to the created reference
                //created earlier
                ob = (SendOb) objectInputStream.readObject();

            } catch (IOException | ClassNotFoundException e) {

            }
            if (ob != null) {
                //if the read object is not null it gets assigned to the static variable "receivedObject"
                ClientWorker.receivedObject = ob;
            }
        }
    }
}

