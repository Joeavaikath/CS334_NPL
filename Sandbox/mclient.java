import java.io.*;
import java.net.*;
import java.util.*;

public class mclient implements Runnable{
    //private static boolean closed = false;
    private static Socket clientSocket;
    private static Scanner inputLine;
    private static Scanner is;
    private static PrintWriter os;

    public static void main(String[] args) throws Exception {

        int portNumber = 2222;
        String host = "localhost";

        clientSocket = new Socket(host, portNumber);
        inputLine = new Scanner(System.in);
        os = new PrintWriter(clientSocket.getOutputStream());
        is = new Scanner(clientSocket.getInputStream());

        /* Create a thread to read from the server. */
        new Thread(new mclient()).start();
        while (true){
            os.println(inputLine.nextLine().trim());
            os.flush();
        }
    }

    public void run(){
        String responseLine;
        try{
            while (true) {
                responseLine = is.nextLine();
                System.out.println(responseLine);
            }
        }
        catch (Exception e) {
            System.out.println("Error : " +e);
        }
          
    }

}
