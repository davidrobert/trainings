package br.com.caelum.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.caelum.modelo.Produto;

@ManagedBean @ViewScoped
public class ProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();
	private List<Produto> produtos;
	private long id = 1l;
	
	public ProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		Produto produto = new Produto();
		produto.setNome("Mouse sem fio");
		produto.setPreco(13.4);
		produto.setDescricao("hardware");
		produto.setId(this.id++);
		this.produtos.add(produto);
	}

	
	public void carregaProduto() {
		System.out.println("carregando produto");
		this.produto = this.produtos.get(this.produto.getId().intValue());
	}
	
	public void grava() {
		System.out.println("gravando produto");
		if(this.produto.getId() == null || this.produto.getId() == 0) {
			this.produto.setId(this.id++);
			this.produtos.add(this.produto);
		}
		this.produto = new Produto();
	}
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}
	
	public void remove() {
		System.out.println("removendo produto");
		this.produtos.remove(this.produto);
		this.produto = new Produto();
	}
	
	public double getSoma() {
		double soma = 0;
		for(Produto p : this.produtos) {
			soma += p.getPreco();
		}
		return soma;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
}
