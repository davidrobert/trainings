
package br.com.caelum.fj91.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={ "id", "descricao", "quantidade", "status" })
public class Produto {

    @XmlType(name="ProductState")
    public enum Status { EM_ESTOQUE, SEM_ESTOQUE, AGUARDANDO_REPOSICAO, DESCONTINUADO };

    private String id;
    private String descricao;
    private int quantidade;
    private Status status;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        status = (quantidade > 0) ? Status.EM_ESTOQUE : Status.SEM_ESTOQUE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == Status.EM_ESTOQUE) {
            assert quantidade > 0;
        } else if (status == Status.SEM_ESTOQUE) {
            assert quantidade == 0;
        }
        this.status = status;
    }
}

