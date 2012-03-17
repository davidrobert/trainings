package br.com.caelum.neo4j.importacoes;

import java.util.Map;
import java.util.Scanner;

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
public class ImportadorApartamentos implements Importador {

	public void importa(BatchInserter inserter, LuceneBatchInserterIndexProvider indexProvider) {
		
		
		Scanner sc = new Scanner(ImportadorApartamentos.class.getResourceAsStream("/import/apartamentos"));
		
		System.out.println("Início da importação dos apartamentos");
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] informacoesDoApartamento = linha.split(";");
			long id = Long.parseLong(informacoesDoApartamento[0]);
			long proprietario = Long.parseLong(informacoesDoApartamento[1]);
			long cidade = Long.parseLong(informacoesDoApartamento[2]);
			String descricao = informacoesDoApartamento[3];
			Double preco = Double.parseDouble(informacoesDoApartamento[4]);

			Map<String, Object> propriedades = MapUtil.map("nome", descricao, "preco", preco);
			
			inserter.createNode(id, propriedades);
			inserter.createRelationship(proprietario, id, Relacionamentos.PROPRIETARIO, null);
			inserter.createRelationship(id, cidade, Relacionamentos.NA_CIDADE, null);
		}
		
		
		
		System.out.println("Fim da importação dos apartamentos");
	}
}
