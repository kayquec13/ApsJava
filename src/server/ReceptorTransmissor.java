package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ReceptorTransmissor {

	private OutputStream envia_m;
	private Writer escreve_m;
	private BufferedWriter e_mensagem;

	private InputStream recebe_m;
	private InputStreamReader ler_m;
	private BufferedReader mensagem;

	private Socket cliente;

	public ReceptorTransmissor(Socket cliente) throws IOException {
		this.cliente = cliente;
		recebe_m = this.cliente.getInputStream();
		ler_m = new InputStreamReader(recebe_m);
		mensagem = new BufferedReader(ler_m);
		envia_m = this.cliente.getOutputStream();
		escreve_m = new OutputStreamWriter(envia_m);
		e_mensagem = new BufferedWriter(escreve_m);
	}

	public BufferedReader receptor() throws IOException {
		return mensagem;
	}

	public BufferedWriter transmissor() throws IOException {
		return e_mensagem;
	}
}
