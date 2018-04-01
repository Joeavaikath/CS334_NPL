import java.io.*;
import java.net.*;

class TCPClient
{
    public static void main(String argv[]) throws Exception
    {
        String s , ms;
        BufferedReader inClient = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket("localhost" , 5555);
        DataOutputStream outServer = new DataOutputStream(client.getOutputStream());
        BufferedReader inServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.print("CLIENT :> ");
        s = inClient.readLine();
        outServer.writeBytes(s + '\n');
        ms = inServer.readLine();
        System.out.println("SERVER :> " + ms);
        client.close();
    }
}
