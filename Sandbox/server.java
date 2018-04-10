import java.io.*;
import java.net.*;
import java.util.*;
class server{
	public static void main(String args[]) throws Exception{

		ServerSocket accept = new ServerSocket(2222);
		Socket connection;
		while (true){

			connection = accept.accept();
			Scanner ip = new Scanner(connection.getInputStream());
			String a = ip.next();
			String b = ip.next();
			String sum = a+b;
			System.out.println("s : "+sum);

			PrintWriter op = new PrintWriter(connection.getOutputStream());
			op.println(sum);
			op.flush();
		}
	}
}
