import java.io.*;
import java.net.*;

class UDPClient
{
    public static void main(String argv[]) throws Exception
    {
        BufferedReader inClient = new BufferedReader(new InputStreamReader(System.in));
        byte[] send = new byte[1024];
        byte[] receive = new byte[1024];
        DatagramSocket client = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        System.out.print("CLIENT :> ");
        String sentence = inClient.readLine();
        send = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(send , send.length , IPAddress , 7777);
        client.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receive , receive.length);
        client.receive(receivePacket);

        String ms = new String(receivePacket.getData());
        System.out.println("SERVER :> " + ms.trim());

        client.close();
    }
}
