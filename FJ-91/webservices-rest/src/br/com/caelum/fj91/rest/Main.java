package br.com.caelum.fj91.rest;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.server.hypermedia.filter.HypermediaFilterFactory;

public class Main {
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost/").port(9998).build();
	}

	public static final URI BASE_URI = getBaseURI();

	@SuppressWarnings("unchecked")
	private static HttpServer startServer() throws IOException {
		System.out.println("Iniciando o Grizzly (servlet container)...");
		
		// Diz qual é o pacote base com os resources do Jersey
		ResourceConfig rc = new PackagesResourceConfig(
				"br.com.caelum.fj91.rest.resources");
		
		// Habilita o suporte a Hypermedia no Jersey
        rc.getResourceFilterFactories().add(HypermediaFilterFactory.class);

		return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
	}

	public static void main(String[] args) throws IOException {
		HttpServer httpServer = startServer();
		System.out.println("Servidor inicializado! Acesse http://localhost:9998/mensagem");
		System.out.println("Para parar o servidor, dê enter no Console ou interrompa o programa");
		System.in.read();
		httpServer.stop();
	}
}