package br.com.caelum.neo4j.importacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Scanner;

import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.impl.lucene.LuceneBatchInserterIndexProvider;
import org.neo4j.kernel.impl.batchinsert.BatchInserter;

import br.com.caelum.neo4j.relacionamentos.Relacionamentos;

/**
 * 
 * Classe que faz a importação de aluguéis do arquivo na pasta import
 * e cria os nós no banco de dados
 *
 */
public class ImportadorAlugueis implements Importador {

	public void importa(BatchInserter inserter, LuceneBatchInserterIndexProvider indexProvider) {
		
		Scanner sc = new Scanner(ImportadorAlugueis.class.getResourceAsStream("/import/alugueis"));
		
		System.out.println("Início da importação dos aluguéis");
		while(sc.hasNextLine()) {
			String linha = sc.nextLine();
			String[] informacoesDeAlugueis = linha.split(";");
			long id = Long.parseLong(informacoesDeAlugueis[0]);
			long pessoa = Long.parseLong(informacoesDeAlugueis[1]);
			long apartamento = Long.parseLong(informacoesDeAlugueis[2]);
			long formaPagamento = Long.parseLong(informacoesDeAlugueis[3]);
			int quantidadeNoites = Integer.parseInt(informacoesDeAlugueis[4]);
			double valor = Double.parseDouble(informacoesDeAlugueis[5]);
			long dataInicio = 0;
			try {
				dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(informacoesDeAlugueis[6]).getTime();
			} catch (ParseException e) {
				throw new RuntimeException("Erro na conversão da data", e);
			}
			int notaAvaliacao = Integer.parseInt(informacoesDeAlugueis[7]);
			
			Map<String, Object> propriedades = MapUtil.map("quantidadeNoites", quantidadeNoites, "valor", valor, "dataInicio", dataInicio);
			
			inserter.createNode(id, propriedades);
			inserter.createRelationship(pessoa, id, Relacionamentos.REALIZOU_ALUGUEL, MapUtil.map("nota", notaAvaliacao));
			inserter.createRelationship(id, apartamento, Relacionamentos.DO_APARTAMENTO, null);
			inserter.createRelationship(id, formaPagamento, Relacionamentos.PAGOU_VIA, null);
		}
		//
		System.out.println("Fim da importação dos aluguéis");
	}
}
