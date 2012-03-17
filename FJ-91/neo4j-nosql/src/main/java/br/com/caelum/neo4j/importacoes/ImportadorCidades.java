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
 * Classe que faz a importação de pessoas do arquivo na pasta import
 * e cria os nós no banco de dados
 *
 */
public class ImportadorCidades implements Importador {

	public void importa(BatchInserter inserter, LuceneBatchInserterIndexProvider indexProvider) {
		
		BatchInserterIndex cidades = indexProvider.nodeIndex("cidades", MapUtil.stringMap("type", "fulltext"));
		
		Scanner sc = new Scanner(ImportadorCidades.class.getResourceAsStream("/import/cidades"));
		
		System.out.println("Início da importação das cidades");
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] informacoesDeCidade = linha.split(";");
			long id = Long.parseLong(informacoesDeCidade[0]);
			String nome = informacoesDeCidade[1];
			long pais = Long.parseLong(informacoesDeCidade[2]);

			Map<String, Object> propriedades = MapUtil.map("nome", nome);
			
			inserter.createNode(id, propriedades);
			cidades.add(id, MapUtil.map("nome", nome));
			inserter.createRelationship(pais, id, Relacionamentos.CIDADE, null);
		}
		
		cidades.flush();
		
		
		System.out.println("Fim da importação das cidades");
	}
}
