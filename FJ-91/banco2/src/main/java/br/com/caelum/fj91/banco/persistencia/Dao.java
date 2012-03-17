package br.com.caelum.fj91.banco.persistencia;

public class Dao<T> {

	private Sessao sessao = new Sessao();
	
	public void adiciona(T t) {
		sessao.salva(t);
	}
	
	public void remove(T t) {
		sessao.remove(t);
	}
	
	public void atualiza(T t) {
		sessao.atualiza(t);
	}
}
