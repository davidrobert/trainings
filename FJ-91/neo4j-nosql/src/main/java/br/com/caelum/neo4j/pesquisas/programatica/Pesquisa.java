package br.com.caelum.neo4j.pesquisas.programatica;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.Traversal;

import br.com.caelum.neo4j.relacionamentos.Relacionamentos;

public class Pesquisa {

	public static void main(String[] args) {
		EmbeddedGraphDatabase db = new EmbeddedGraphDatabase("neo4j-dbstore");
		long inicio = System.currentTimeMillis();
		Node pessoa = db.getNodeById(1);
		Iterable<Node> nodes = Traversal.description()
			.depthFirst()
			.relationships(Relacionamentos.REALIZOU_ALUGUEL, Direction.OUTGOING)
			.relationships(Relacionamentos.DO_APARTAMENTO, Direction.OUTGOING)
			.relationships(Relacionamentos.DO_APARTAMENTO, Direction.INCOMING)
			.relationships(Relacionamentos.REALIZOU_ALUGUEL, Direction.INCOMING)
			.evaluator(Evaluators.atDepth(4))
			.evaluator(Evaluators.excludeStartPosition())
			.traverse(pessoa)
			.nodes();
		
		for (Node node : nodes) {
			System.out.println(node.getProperty("nome"));
		}
		long fim = System.currentTimeMillis();
		
		System.out.println("Tempo de execução em ms: " + (fim - inicio));
		db.shutdown();
	}
}
