package br.com.caelum.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class Dicionario {

	private Map<String, String> mapa;

	public Dicionario() {
		this.mapa = new HashMap<String, String>();
		this.mapa.put("bola", "ball");
		this.mapa.put("casa", "house");
		this.mapa.put("palavra", "word");
	}

	@WebMethod @WebResult(name="traducao")
	public String traduz(@WebParam(name="palavra") String palavra) {
		return this.mapa.get(palavra);
	}

	//wsgen -s src -d src -cp bin -wsdl -keep br.com.caelum.ws.Dicionario
 
}