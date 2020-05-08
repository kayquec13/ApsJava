package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RecebeMensagem {
	private BufferedWriter cliente;
	private String nome;
	private String msg;

	public String recebeMensagem(BufferedReader mensagem, BufferedWriter e_mensagem) throws IOException {
		msg = nome + " -> " + mensagem.readLine();
		return msg;
	}

	public String handShake(BufferedReader mensagem, BufferedWriter e_mensagem) throws IOException {
		cliente = e_mensagem;
		nome = mensagem.readLine();
		msg = nome + " entrou na sala";
		return msg;
	}

	public BufferedWriter getCliente() {
		return cliente;
	}
}
