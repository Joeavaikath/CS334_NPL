import java.io.*;
import java.net.*;

class UDPServer
{
    public static void main(String argv[]) throws Exception
    {
        DatagramSocket server = new DatagramSocket(7777);
        byte[] receive = new byte[1024];
        byte[] send = new byte[1024];

        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receive , receive.length);
            server.receive(receivePacket);

            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String capS = sentence.toUpperCase() + '\n';
            send = capS.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(send , send.length , IPAddress , port);

            server.send(sendPacket);
        }
    }
}
