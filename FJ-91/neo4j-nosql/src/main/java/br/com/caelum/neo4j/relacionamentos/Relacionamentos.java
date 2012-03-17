package br.com.caelum.neo4j.relacionamentos;

import org.neo4j.graphdb.RelationshipType;

public enum Relacionamentos implements RelationshipType {
	PESSOA, PAIS, CIDADE, PROPRIETARIO, NA_CIDADE, REALIZOU_ALUGUEL, DO_APARTAMENTO, PAGOU_VIA
}
