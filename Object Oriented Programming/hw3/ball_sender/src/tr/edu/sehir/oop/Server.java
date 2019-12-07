package tr.edu.sehir.oop;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Server implements Runnable{
    private ServerSocket serverSocket;
    private int clientNo = 0;


    void startServer() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost(); // "DESKTOP-0B5QR2D/10.52.10.12" (Ibrahim's IP)
        System.out.println("Server's IP: " + inetAddress);

        try{
            serverSocket = new ServerSocket(4321);
            System.out.println("Server started");
        } catch (IOException e) {
            System.out.println("Could not listen on port 4321");
            System.exit(-1);
        }
    }
    @Override
    public void run() {
        try {
            ClientWorker w = new ClientWorker(serverSocket.accept(), clientNo);
            Thread t = new Thread(w);
            t.start();
            clientNo++;
        } catch (IOException e) {
            System.out.println("Accept failed: 4444");
            System.exit(-1);
        }
    }
}
