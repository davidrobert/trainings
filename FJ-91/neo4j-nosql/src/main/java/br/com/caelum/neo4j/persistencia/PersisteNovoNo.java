package br.com.caelum.neo4j.persistencia;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.kernel.EmbeddedGraphDatabase;

import br.com.caelum.neo4j.relacionamentos.Relacionamentos;

public class PersisteNovoNo {

	public static void main(String[] args) {
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		Transaction tx = db.beginTx();
		
		try {
			String nomeDaCidade = "Guarujá";
			Node novaCidade = db.createNode();
			novaCidade.setProperty("nome", nomeDaCidade);
			
			Index<Node> indiceCidades = db.index().forNodes("cidades");
			indiceCidades.add(novaCidade, "nome", nomeDaCidade);
			
			Index<Node> indicePaises = db.index().forNodes("paises");
			Node brasil = indicePaises.get("nome", "Brasil").next();
			
			brasil.createRelationshipTo(novaCidade, Relacionamentos.CIDADE);
			tx.success();
		} finally {
			tx.finish();
		}
		db.shutdown();
	}
}
