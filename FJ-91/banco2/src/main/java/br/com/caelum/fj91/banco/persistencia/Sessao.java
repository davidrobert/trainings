package br.com.caelum.fj91.banco.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.fj91.banco.modelo.Cliente;
import br.com.caelum.fj91.banco.modelo.Conta;

public class Sessao {

	// guarda objetos de determinada classe
	private static Map<Class<?>, List<Object>> contexto = new HashMap<Class<?>, List<Object>>();
	static {
		contexto.put(Conta.class, new ArrayList<Object>());
		contexto.put(Cliente.class, new ArrayList<Object>());
	}
	
	public void salva(Object o) {
		System.out.println("Adicionando novo objeto " + o.getClass().getName());
		contexto.get(o.getClass()).add(o);
	}
	
	public void atualiza(Object o) {
		// nao faz nada, ja esta na memoria
	}
	
	public void remove(Object o) {
		System.out.println("Removendo objeto " + o.getClass().getName());
		contexto.get(o.getClass()).remove(o);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> lista(Class<T> clazz) {
		return (List<T>) contexto.get(clazz);
	}
}
