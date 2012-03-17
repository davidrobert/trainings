package br.com.caelum.jsf.bean;

import java.util.List;

import br.com.caelum.jsf.dao.ProdutoDAO;
import br.com.caelum.jsf.modelo.Produto;

public class ProdutoHandler {

	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String adiciona() {
		ProdutoDAO dao = new ProdutoDAO();
		dao.adiciona(produto);
		produto = new Produto();
		return "ok";
	}
	
	public List<Produto> getProdutos() {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.getLista();
	}
}
