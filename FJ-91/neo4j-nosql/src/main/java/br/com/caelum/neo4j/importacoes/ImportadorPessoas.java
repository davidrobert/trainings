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
public class ImportadorPessoas implements Importador {

	public void importa(BatchInserter inserter, LuceneBatchInserterIndexProvider indexProvider) {
		
		BatchInserterIndex pessoas = indexProvider.nodeIndex("pessoas", MapUtil.stringMap("type", "fulltext"));
		
		Scanner sc = new Scanner(ImportadorPessoas.class.getResourceAsStream("/import/pessoas"));
		
		System.out.println("Início da importação das pessoas");
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] informacoesDePessoa = linha.split(";");
			long id = Long.parseLong(informacoesDePessoa[0]);
			String nome = informacoesDePessoa[1];
			Integer idade = Integer.parseInt(informacoesDePessoa[2]);

			Map<String, Object> propriedades = MapUtil.map("nome", nome, "idade", idade);
			
			inserter.createNode(id, propriedades);
			pessoas.add(id, MapUtil.map("nome", nome));
			inserter.createRelationship(0, id, Relacionamentos.PESSOA, null);
		}
		
		pessoas.flush();
		
		
		System.out.println("Fim da importação das pessoas");
	}
}
