package br.com.caelum.neo4j.pesquisas.cypher;

import java.util.Iterator;
import java.util.Map;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class Pesquisa4 {

	/**
	 * Quem alugou o mesmo apartamento que uma pessoa, alugou também em quais outras cidades? 
	 */
	public static void main(String[] args) {
		long id = 5;
		Map<String, Object> params = MapUtil.map("id", id);
		String query = "start n=node({id}) match n-[:REALIZOU_ALUGUEL]->()-[:DO_APARTAMENTO]->()<-[:DO_APARTAMENTO]-()<-[:REALIZOU_ALUGUEL]-()-[:REALIZOU_ALUGUEL]->outrosAlugueis-[:DO_APARTAMENTO]->()-[:NA_CIDADE]->cidades return distinct cidades";
		
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		ExecutionEngine engine = new ExecutionEngine(db);
		ExecutionResult result = engine.execute(query, params);
		
		Iterator<Node> cidades = result.columnAs("cidades");
		while(cidades.hasNext()) {
			Node cidade = cidades.next();
			System.out.println(cidade.getProperty("nome"));
		}
		db.shutdown();
	}
}
