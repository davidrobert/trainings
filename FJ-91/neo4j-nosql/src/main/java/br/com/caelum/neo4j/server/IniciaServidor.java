package br.com.caelum.neo4j.server;

import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.server.WrappingNeoServerBootstrapper;

public class IniciaServidor {

	public static void main(String[] args) throws InterruptedException {
		final EmbeddedGraphDatabase db = new EmbeddedGraphDatabase(
				"neo4j-dbstore");

		final WrappingNeoServerBootstrapper server = new WrappingNeoServerBootstrapper(
				db);
		server.start();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				server.stop();
				db.shutdown();
			}
		});
		
	}

}
