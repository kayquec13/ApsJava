package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EnviaMensagem {
	
	public void enviaMensagem(BufferedWriter mensagem, String msg, ArrayList<BufferedWriter> clientes) throws IOException {
		
		for (BufferedWriter msage : clientes) {
			if (msage != mensagem) {
				msage.write (msg + "\r\n");
				msage.flush();
			}
		}
	}
	

}
