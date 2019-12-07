package tr.edu.sehir.oop;

import java.io.*;
import java.net.Socket;

public class ClientWorker implements Runnable {
    private Socket clientSocket;
    public static SendOb receivedObject = null;
    //Constructor
    ClientWorker(Socket client, int clientNo) {
        clientSocket = client;
        System.out.println("client number " + clientNo + " has connected to server");
    }

    public void run(){
        ObjectInputStream objectInputStream = null;
        try{

            InputStream inputStream = clientSocket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

        } catch (IOException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }



        while (true) {
            SendOb ob = null;
            try {
                ob = (SendOb) objectInputStream.readObject();


            } catch (IOException | ClassNotFoundException e) {
            }
            if (ob != null) {
                ClientWorker.receivedObject = ob;
            }
        }
    }
}

