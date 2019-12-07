package tr.edu.sehir.oop;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class Client {
    private String hostname;
    Client(String hostname) {
        this.hostname = hostname;
    }

    void startClient(SendOb ballobj) throws IOException {
        System.out.println("Client started");
        int portNumber = 4321;
        Socket socket;
        System.out.print("Connecting to server \n");
        while (true) {
            try {
                socket = new Socket(hostname, portNumber);
                break;
            } catch (Exception ignored) {
            }
        }

        try {
            //creating an output stream to send the objects that contains the captured attributes of the ball
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(ballobj); //writing to the output stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
