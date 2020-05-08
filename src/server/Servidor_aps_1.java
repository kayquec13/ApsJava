package server;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.ArrayList;

public class Servidor_aps_1 extends Thread {

	private String msg;
	private static ServerSocket servidor;
	private Socket cliente;

	EnviaMensagem enviaMensagem;
	RecebeMensagem recebeMensagem;
	ReceptorTransmissor rt;
	BufferedReader mensagem;
	BufferedWriter e_mensagem;
	public static ArrayList<BufferedWriter> clientes;

	public Servidor_aps_1(Socket cliente) throws IOException {
		this.cliente = cliente;
		rt = new ReceptorTransmissor(this.cliente);
	}

	public void run() {

		try {
			mensagem = rt.receptor();
			e_mensagem = rt.transmissor();

			if (enviaMensagem == null && recebeMensagem == null) {
				enviaMensagem = new EnviaMensagem();
				recebeMensagem = new RecebeMensagem();
				msg = recebeMensagem.handShake(mensagem, e_mensagem);
				clientes.add(recebeMensagem.getCliente());
				enviaMensagem.enviaMensagem(e_mensagem, msg, clientes);
			}

			while (true) {
				msg = recebeMensagem.recebeMensagem(mensagem, e_mensagem);
				enviaMensagem.enviaMensagem(e_mensagem, msg, clientes);
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
			fechaConexao();
		}
	}

	public void fechaConexao() {
		try {
			BufferedWriter cliente = recebeMensagem.getCliente();
			for (BufferedWriter cli : clientes) {
				if (cli == cliente) {
					clientes.remove(clientes.indexOf(cli));
				}
			}
			cliente.close();
			mensagem.close();
			e_mensagem.close();
			interrupt();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		int porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a Porta do Servidor: ", 12345));
		servidor = new ServerSocket(porta);
		JOptionPane.showMessageDialog(null, "Porta: " + porta + " aberta para comunicação.");
		new ArrayList<BufferedWriter>();
		Thread connection = new OpenServer(servidor);
		connection.start();
		clientes = new ArrayList<>();

		while (true) {
			System.out.println("Aguardando conexão...");
			Socket con = servidor.accept();
			System.out.println("Cliente conectado - IP: ");
			Thread t = new Servidor_aps_1(con);
			t.start();
		}
	}
}
