import java.io.*;
import java.util.*;
import java.net.*;

class client{
	public static void main(String args[]) throws Exception{
	String s1 , s2, s3;
	int n1,n2,s; 
        Scanner inClient = new Scanner(System.in);
        Socket client = new Socket("localhost" , 2222);
        PrintWriter outServer = new PrintWriter(client.getOutputStream());
        Scanner inServer = new Scanner(client.getInputStream());

        System.out.println("String1 :> ");
        s1 = inClient.next();
	System.out.println("num2 :> ");
	s2 = inClient.next();

        outServer.println(s1);
	outServer.flush();
	outServer.println(s2);
	outServer.flush();
        s3 = inServer.next();
        System.out.println("Sum :> " + s3);
        client.close();
	}
}

