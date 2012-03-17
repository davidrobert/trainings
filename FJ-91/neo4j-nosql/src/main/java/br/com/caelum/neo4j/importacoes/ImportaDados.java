package br.com.caelum.neo4j.importacoes;

import org.neo4j.index.impl.lucene.LuceneBatchInserterIndexProvider;
import org.neo4j.kernel.impl.batchinsert.BatchInserter;
import org.neo4j.kernel.impl.batchinsert.BatchInserterImpl;

public class ImportaDados {
	public static void main(String[] args) {
		BatchInserter inserter = new BatchInserterImpl("neo4j-dbstore");
		LuceneBatchInserterIndexProvider indexProvider = new LuceneBatchInserterIndexProvider(inserter);
		
		new ImportadorPessoas().importa(inserter, indexProvider);
		new ImportadorPaises().importa(inserter, indexProvider);
		new ImportadorCidades().importa(inserter, indexProvider);
		new ImportadorApartamentos().importa(inserter, indexProvider);
		new ImportadorFormasPagamento().importa(inserter, indexProvider);
		new ImportadorAlugueis().importa(inserter, indexProvider);
		
		indexProvider.shutdown();
		inserter.shutdown();
	}
}
