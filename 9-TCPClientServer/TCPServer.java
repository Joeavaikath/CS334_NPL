import java.io.*;
import java.net.*;

class TCPServer
{
    public static void main(String argv[]) throws Exception
    {
        String clientS , capS;
        ServerSocket welcome = new ServerSocket(5555);

        while(true)
        {
            Socket connection = welcome.accept();
            BufferedReader inClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream outClient = new DataOutputStream(connection.getOutputStream());

            clientS = inClient.readLine();
            capS = clientS.toUpperCase() + '\n';
            outClient.writeBytes(capS);
        }
    }
}
