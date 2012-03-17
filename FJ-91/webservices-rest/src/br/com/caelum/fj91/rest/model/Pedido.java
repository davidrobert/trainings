
package br.com.caelum.fj91.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id", "cliente", "enderecoEnvio",
                    "itensPedido", "observacao", "status" })
public class Pedido {

    @XmlType(name="StatusPedido")
    public enum Status { RECEBIDO, REVISADO, CANCELADO, PAGO, ENVIADO };

    public static class ItemPedido {
        Produto produto;
        int quantidade;

        public ItemPedido() {
        }

        public ItemPedido(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }

    private String id;
    private Cliente cliente;
    private Endereco enderecoEnvio;
    private List<ItemPedido> itensPedido;
    private String observacao;
    private Status status;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
    
    public List<ItemPedido> getItensPedido() {
        if (itensPedido == null) {
            itensPedido = new ArrayList<ItemPedido>();
        }
        return itensPedido;
    }

    public Endereco getEnderecoEnvio() {
        return enderecoEnvio;
    }

    public void setEnderecoEnvio(Endereco enderecoEnvio) {
        this.enderecoEnvio = enderecoEnvio;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
