package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		
		 OutputStream ou ;
		 Writer ouw; 
		 BufferedWriter bfw;
		
		   Socket socket = new Socket("127.0.0.1", Integer.parseInt("12345"));
		   ou = socket.getOutputStream();
			  ouw = new OutputStreamWriter(ou);
			  bfw = new BufferedWriter(ouw);
			  bfw.write("oi \r\n");
			  bfw.flush();
		   InputStream in = socket.getInputStream();
		   InputStreamReader inr = new InputStreamReader(in);
		   BufferedReader bfr = new BufferedReader(inr);
		   String msg = "";
		   while(true) {
			   msg = bfr.readLine();
			   System.out.println(msg);
		   }

	}
}