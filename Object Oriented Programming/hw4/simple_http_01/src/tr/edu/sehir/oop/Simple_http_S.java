package tr.edu.sehir.oop;
import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

public class Simple_http_S{

    ServerSocket server;

    public void startServer(){
        try{
            server = new ServerSocket(4321);
            System.out.println("server started! ");
        } catch (IOException e) {
            System.out.println("Could not listen on port 4321");
            System.exit(-1);
        }
        while(true){
            ClientW w;
            try{
                //server.accept returns a client connection
                w = new ClientW(server.accept());
                Thread t = new Thread(w);
                System.out.println(t.getName()+ " starting");
                t.start();

            } catch (IOException  e) {
                System.out.println("Accept failed: 4444");
                System.exit(-1);
            }

        }
    }
}