package br.com.caelum.neo4j.persistencia;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class ExcluiNo {

	public static void main(String[] args) {
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		Transaction tx = db.beginTx();
		
		try {
			String nomeDaCidade = "Guarujá";
			Index<Node> indiceCidades = db.index().forNodes("cidades");
			Node cidade = indiceCidades.get("nome", nomeDaCidade).next();
			
			/*
			for(Relationship r : cidade.getRelationships()) {
				r.delete();
			}
			*/
			
			cidade.delete();
			
			tx.success();
		} finally {
			tx.finish();
		}
		db.shutdown();
	}

}
