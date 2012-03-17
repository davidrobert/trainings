
package br.com.caelum.fj91.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={ "id", "nome", "enderecos", "numeroCartao", "status" })
public class Cliente {

    @XmlType(name="StatusCliente")
    public enum Status { ATIVO, SUSPENSO };

    private String id;
    private String nome;
    private List<Endereco> enderecos;
    private String numeroCartao;
    private Status status;

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public List<Endereco> getEnderecos() {
        if (enderecos == null) {
            enderecos = new ArrayList<Endereco>();
        }
        return enderecos;
    }

    public Endereco getEnderecoById(String id) {
        if (enderecos != null) {
            for (Endereco a : enderecos) {
                if (a.getId().equals(id)) return a;
            }
        }
        return null;
    }
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
