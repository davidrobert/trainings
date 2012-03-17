package br.com.caelum.neo4j.importacoes;

import java.util.Map;
import java.util.Scanner;

import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.impl.lucene.LuceneBatchInserterIndexProvider;
import org.neo4j.kernel.impl.batchinsert.BatchInserter;

/**
 * 
 * Classe que faz a importação de pessoas do arquivo na pasta import
 * e cria os nós no banco de dados
 *
 */
public class ImportadorFormasPagamento implements Importador {

	public void importa(BatchInserter inserter, LuceneBatchInserterIndexProvider indexProvider) {
		
		Scanner sc = new Scanner(ImportadorFormasPagamento.class.getResourceAsStream("/import/formas_pagamento"));
		
		System.out.println("Início da importação das formas de pagamento");
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] informacoesDeFormaDePagamento = linha.split(";");
			long id = Long.parseLong(informacoesDeFormaDePagamento[0]);
			String nome = informacoesDeFormaDePagamento[1];

			Map<String, Object> propriedades = MapUtil.map("nome", nome);
			
			inserter.createNode(id, propriedades);
		}
		
		System.out.println("Fim da importação das formas de pagamento");
	}
}
