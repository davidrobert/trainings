package br.com.caelum.fj91.js;

import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ProgramaSwing {
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        
        //Abra o arquivo swing.js
        engine.eval(new InputStreamReader(ProgramaSwing.class.getResourceAsStream("/swing.js")));
	}
}
