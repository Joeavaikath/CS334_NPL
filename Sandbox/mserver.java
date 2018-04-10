import java.io.*;
import java.net.*;
import java.util.*;

public class mserver {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    private static final int maxClientsCount = 10;
    private static final clientThread threads[] = new clientThread[maxClientsCount];

    public static void main(String args[]) throws Exception {

        int portNumber = 2222;
        serverSocket = new ServerSocket(portNumber);
        //Create a client socket for each connection and pass it to a new client thread.
        while (true) {
            clientSocket = serverSocket.accept();
            int i = 0;
            for (i = 0; i < maxClientsCount; i++) {
                if (threads[i] == null) {
                    threads[i] = new clientThread(clientSocket, threads);
                    threads[i].start();
                    break;
                }
            }
        }
    }
}

class clientThread extends Thread {

    private Scanner is = null;
    private PrintStream os = null;
    private Socket clientSocket = null;
    private final clientThread threads[];
    private int maxClientsCount;

    public clientThread(Socket clientSocket, clientThread threads[]) {
        this.clientSocket = clientSocket;
        this.threads = threads;
        maxClientsCount = threads.length;
    }

    public void run() {
        int maxClientsCount = this.maxClientsCount;
        clientThread threads[] = this.threads;

        try{
            is = new Scanner(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            String name;
            os.println("Enter name :");
            name = is.nextLine().trim();

            /* Welcome the new the client. */
            os.println(name + " added to group\n");
            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] != null && threads[i] != this) {
                        threads[i].os.println(name + " added to group\n");
                    }
                }
            }
            /* Start the conversation. */
            while (true) {
                String line = is.nextLine();
                synchronized (this) {
                    for (int i = 0; i < maxClientsCount; i++) {
                        if (threads[i] != null){
                            threads[i].os.println("<" + name + "> " + line);
                        }
                    }
                }
            }
        }
        catch (IOException e) {
        }
    }
}
