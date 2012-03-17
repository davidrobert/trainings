package br.com.caelum.neo4j.importacoes;

import org.neo4j.index.impl.lucene.LuceneBatchInserterIndexProvider;
import org.neo4j.kernel.impl.batchinsert.BatchInserter;

public interface Importador {

	public abstract void importa(BatchInserter inserter,
			LuceneBatchInserterIndexProvider indexProvider);

}