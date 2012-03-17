package br.com.caelum.ws;

import javax.xml.ws.Endpoint;

public class PublicaEndpoint {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/Dicionario", new Dicionario());
		System.out.println("publicado, acesse: http://localhost:8080/Dicionario?wsdl");
	}
}