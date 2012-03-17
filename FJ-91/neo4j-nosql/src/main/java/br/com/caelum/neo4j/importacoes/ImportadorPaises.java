package br.com.caelum.neo4j.importacoes;

import java.util.Map;
import java.util.Scanner;

import org.neo4j.graphdb.index.BatchInserterIndex;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.impl.lucene.LuceneBatchInserterIndexProvider;
import org.neo4j.kernel.impl.batchinsert.BatchInserter;

import br.com.caelum.neo4j.relacionamentos.Relacionamentos;

/**
 * 
 * Classe que faz a importação de países do arquivo na pasta import
 * e cria os nós no banco de dados
 *
 */
public class ImportadorPaises implements Importador {

	public void importa(BatchInserter inserter, LuceneBatchInserterIndexProvider indexProvider) {
		
		BatchInserterIndex paises = indexProvider.nodeIndex("paises", MapUtil.stringMap("type", "exact"));
		
		Scanner sc = new Scanner(ImportadorPaises.class.getResourceAsStream("/import/paises"));
		
		System.out.println("Início da importação dos países");
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] informacoesDePais = linha.split(";");
			long id = Long.parseLong(informacoesDePais[0]);
			String nome = informacoesDePais[1];

			Map<String, Object> propriedades = MapUtil.map("nome", nome);
			
			inserter.createNode(id, propriedades);
			paises.add(id, MapUtil.map("nome", nome));
			inserter.createRelationship(0, id, Relacionamentos.PAIS, null);
		}
		
		paises.flush();
		
		
		System.out.println("Fim da importação dos pessoas");
	}
}
