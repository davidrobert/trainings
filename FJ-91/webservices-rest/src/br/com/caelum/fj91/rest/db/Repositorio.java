package br.com.caelum.fj91.rest.db;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.fj91.rest.model.Endereco;
import br.com.caelum.fj91.rest.model.Cliente;
import br.com.caelum.fj91.rest.model.Pedido;
import br.com.caelum.fj91.rest.model.Produto;

public class Repositorio {

	/**
	 * Simulando um banco de dados de verdade, com pedidos, clientes e produtos
	 */
	
	public static final Map<String, Pedido> pedidos = new HashMap<String, Pedido>();
    public static final Map<String, Cliente> clientes = new HashMap<String, Cliente>();
    public static final Map<String, Produto> produtos = new HashMap<String, Produto>();

    // Adiciona alguns dados iniciais no banco em memória
    static {
        Endereco endereco = new Endereco();
        endereco.setId("1");
        endereco.setNumero("1");
        endereco.setRua("Rua Vergueiro 1111");
        endereco.setCidade("Sao Paulo");
        endereco.setEstado("SP");
        endereco.setCidade("Brasil");

        Cliente cliente = new Cliente();
        cliente.setId("21");
        cliente.setNome("João");
        cliente.getEnderecos().add(endereco);
        endereco.setCliente(cliente);
        cliente.setNumeroCartao("123456789");
        cliente.setStatus(Cliente.Status.SUSPENSO);
        clientes.put(cliente.getId(), cliente);

        Produto produto = new Produto();
        produto.setId("3345");
        produto.setDescricao("Bomba de encher bola");
        produto.setQuantidade(5);
        produto.setStatus(Produto.Status.EM_ESTOQUE);
        produtos.put(produto.getId(), produto);

        Pedido pedido = new Pedido();
        pedido.setId("1");
        pedido.setCliente(cliente);
        pedido.getItensPedido().add(
                new Pedido.ItemPedido(produto, 1));
        pedido.setEnderecoEnvio(endereco);
        pedido.setStatus(Pedido.Status.RECEBIDO);
        pedidos.put(pedido.getId(), pedido);

        pedido = new Pedido();
        pedido.setId("2");
        pedido.setCliente(cliente);
        pedido.getItensPedido().add(
                new Pedido.ItemPedido(produto, 2));
        pedido.setEnderecoEnvio(endereco);
        pedido.setStatus(Pedido.Status.PAGO);
        pedidos.put(pedido.getId(), pedido);
    }
}
