package tr.edu.sehir.oop;
import java.io.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


// reading from text file
import java.util.Scanner;

import java.net.Socket;



class ClientW implements Runnable {
    private Socket client;

    //Constructor
    ClientW(Socket client) {
        this.client = client;

    }

    public void run(){
        String line;
        BufferedReader in = null;
        PrintWriter out = null;
        String resp = "";
        try{
            in = new BufferedReader(new
                    InputStreamReader(client.getInputStream()));

            out = new
                    PrintWriter(client.getOutputStream(), true);
            Thread.sleep( 1000);
        } catch (IOException | InterruptedException e) {
            System.out.println("in or out failed");
            System.exit(-1);
        }

        //while(true){
            try{
                line = in.readLine();

                //printing read line
//                System.out.println("line read from client: " + line);


                long time = System.currentTimeMillis();

                // Creating date format
                DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");

                // Creating date from milliseconds
                // using Date() constructor
                Date result = new Date(time);
                // Formatting Date according to the
                // given format
//                System.out.println(simple.format(result));
                if (line.equals("GET /web/namesform.html HTTP/1.1")){
                    resp =  readHtmlFile("namesform.html");

                } else if (line.equals("GET / HTTP/1.1")) {
                    //Send data back to client
                    resp =  readHtmlFile("welcome.html");

                } else if (line.equals("POST /web/namesHandler HTTP/1.1")){
                    int lengthOfPostData = -1;
                    while ((line = in.readLine()) != null && (line.length() != 0)) { //iterating through the lines (request) we got from the client
                        //The Content-Length header is a number denoting an the exact byte length of the HTTP body: message body represents
                        if (line.contains("Content-Length:")) {
                            lengthOfPostData = Integer.parseInt(line.substring(line.indexOf("Content-Length:") + 16, line.length())); //substring is a way of slicing the str
                        }
                    }
                    String inputtedData = "";
                    for (int i = 0; i < lengthOfPostData; i++) {
                        int intParser = in.read();  //read is used to read a single int from the stream
                        inputtedData += (char) intParser; //converting the integers into characters
                    }
                    String inputtedName = inputtedData.substring(10, inputtedData.length()).toLowerCase(); // getting the name from (firstname=Name)

                    //reading the names from the text file and checking if the inputted name exists in the file
                    //then respond accordingly
                    Path path = FileSystems.getDefault().getPath("registeredNames.txt"); //getting the relative path of the text file
                    File file = new File(String.valueOf(path)); // creating a file object to read from the file
                    Scanner sc = new Scanner(file);
                    String readName;
                    boolean nameExists = false;
                    while (sc.hasNextLine()){
                        readName = sc.nextLine().toLowerCase();
                        if (readName.equals(inputtedName)) {
                            resp =  readHtmlFile("success.html");
                            nameExists = true;
                        }
                    }
                     if (!nameExists) {
                         resp =  readHtmlFile("failure.html");
                    }
                }
                out.println(resp);

            in.close();
            out.close();

            }catch (IOException e) {
                System.out.println("Read failed");
                System.exit(-1);
            }
        //}
    }


    String readHtmlFile(String fileName){
        //string builders are string objects that can be modified
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in_f = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = in_f.readLine()) != null) {
                contentBuilder.append(str);
            }
            in_f.close();
        } catch (IOException e) {
        }
        return  "HTTP/1.1 200 OK\n\n" + contentBuilder.toString();
    }
}