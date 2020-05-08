package server;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JOptionPane;

public class OpenServer extends Thread {
	
	private ServerSocket con;

	public OpenServer(ServerSocket connection) {
		this.con = connection;
	}

	public void run() {
		String[] options = new String[] { "Desconectar / Sair" };
		while (true) {
			
			String info = "Porta: " + String.valueOf(con.getLocalPort()) + "\n";
			
			if (con.isClosed() != false) {
				info += "Status: Desconectado";
			}
			else {
				info += "Status: Conectado";
			}
			
			int valor = JOptionPane.showOptionDialog(null, info, "Servidor", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			if (valor == 0) {
				try {
					con.close();
					JOptionPane.showMessageDialog(null, "Servidor Desconectado. Saindo...");
					System.exit(0);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
