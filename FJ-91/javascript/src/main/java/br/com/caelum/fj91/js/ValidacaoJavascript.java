package br.com.caelum.fj91.js;

import java.io.InputStreamReader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ValidacaoJavascript {
	public static void main(String[] args) throws ScriptException {
		
		// Monta o contexto do Rhino
		ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        ScriptContext context = engine.getContext();
        context.setAttribute("name", "Javascript", ScriptContext.ENGINE_SCOPE);
        
        // Cria o binding para passar um objeto do Java para o Javascript
        Bindings bindings = engine.createBindings();
        
        // Interpreta o arquivo Javascript
        engine.eval(new InputStreamReader(ValidacaoJavascript.class.getResourceAsStream("/validacoes.js")), bindings);
        
        // Disponibiliza objeto Java para o Javascript 
        String fraseEmMinusculo = "frase começando em minúsculo";
		bindings.put("valor", fraseEmMinusculo);

		
		// Invoca a validação para saber se começa com maiúscula
		// comecaComMaiuscula(valor) é uma função no script validacoes.js
		Object comecaComMaiuscula = engine.eval("comecaComMaiuscula(valor)", bindings);
        System.out.println("\"" + fraseEmMinusculo +  "\" começa com maiúscula? " + comecaComMaiuscula);

        
        // Disponibiliza objeto Java para o Javascript
        bindings.put("texto", "pouco texto");
        bindings.put("tamanhoMinimo", 20);

        // Invoca a validação para saber se possui um tamanho mínimo
        // possuiMinimoDeCaracteres(....) é uma função no script validacoes.js
        Object possuiTamanhoMinimo = engine.eval("possuiMinimoDeCaracteres(texto, tamanhoMinimo)", bindings);
        System.out.println("O texto possui o tamanho mínimo? " + possuiTamanhoMinimo);
	}
}
