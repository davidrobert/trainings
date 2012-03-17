package br.com.caelum.neo4j.pesquisas.cypher;

import java.util.Iterator;
import java.util.Map;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class Pesquisa1 {

	/**
	 * Buscar um país pelo índice 
	 */
	public static void main(String[] args) {
		String nomeDoPais = "Brasil";
		Map<String, Object> params = MapUtil.map("nome", nomeDoPais);
		String query = "start n=node:paises(nome = {nome}) return n";
		
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		ExecutionEngine engine = new ExecutionEngine(db);
		ExecutionResult result = engine.execute(query, params);
		
		Iterator<Node> cidades = result.columnAs("n");
		while(cidades.hasNext()) {
			Node cidade = cidades.next();
			System.out.println(cidade.getProperty("nome"));
		}
		
		db.shutdown();
	}

}
