package br.com.caelum.neo4j.persistencia;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class AlteraNo {

	public static void main(String[] args) {
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		Transaction tx = db.beginTx();
		
		try {
			Node pessoa = db.getNodeById(1);
			pessoa.setProperty("nome", "<< SEU NOME AQUI >>");
			tx.success();
		} finally {
			tx.finish();
		}
		db.shutdown();
	}

}
