package server;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class EnviaJSON {
	
	public void mensagem(String usuario,String mensagem) throws IOException {
		JSONArray arquivo = new JSONArray();
		JSONArray message = new JSONArray();
		JSONObject dadosCliente = new JSONObject();
		JSONObject teste = new JSONObject();
		JSONObject mensagens = new JSONObject();
		JSONObject mensagensInfo = new JSONObject();
		mensagens.put("mensagem", "opa");
		
		ArrayList<JSONObject> opa = new ArrayList<>();
		
		for(int i =0;i<3;i++) {
		mensagensInfo.put("texto", mensagem);
		mensagensInfo.put("usuario","ze");
		opa.add(mensagensInfo);
		}
		message.add(opa);
		
		dadosCliente.put("id",1);
		dadosCliente.put("usuario",usuario);
		dadosCliente.put("mensagens",opa);
		arquivo.add(dadosCliente);

		FileWriter file = new FileWriter("C:\\users\\tigo\\desktop\\teste\\msg.json");
		file.write(arquivo.toJSONString());
		file.flush();
	}
}
