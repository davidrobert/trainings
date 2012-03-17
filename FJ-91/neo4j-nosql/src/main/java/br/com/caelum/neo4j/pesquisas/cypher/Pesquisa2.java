package br.com.caelum.neo4j.pesquisas.cypher;

import java.util.Iterator;
import java.util.Map;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class Pesquisa2 {

	/**
	 * Buscar as cidades de um determinado país ordenadas pelo nome
	 */
	public static void main(String[] args) {
		String nomeDoPais = "Japão";
		Map<String, Object> params = MapUtil.map("nome", nomeDoPais);
		String query = "start n=node:paises(nome = {nome}) match n-[:CIDADE]->cidades return cidades order by cidades.nome";
		
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
