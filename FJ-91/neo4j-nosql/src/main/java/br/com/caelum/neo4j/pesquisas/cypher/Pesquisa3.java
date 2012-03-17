package br.com.caelum.neo4j.pesquisas.cypher;

import java.util.Iterator;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Relationship;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class Pesquisa3 {

	/**
	 * Buscar avaliações dos apartamentos de alguém cuja nota for maior ou igual que 2
	 */
	public static void main(String[] args) {
		String query = "start n=node(2) match n-[:PROPRIETARIO]->()<-[:DO_APARTAMENTO]->()<-[aluguel:REALIZOU_ALUGUEL]-() where aluguel.nota >= 2 return aluguel";
		
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		ExecutionEngine engine = new ExecutionEngine(db);
		ExecutionResult result = engine.execute(query);
		
		Iterator<Relationship> cidades = result.columnAs("aluguel");
		while(cidades.hasNext()) {
			Relationship aluguel = cidades.next();
			System.out.println(aluguel.getProperty("nota"));
		}
		
		db.shutdown();
	}

}
