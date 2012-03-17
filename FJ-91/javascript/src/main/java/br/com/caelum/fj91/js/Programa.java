package br.com.caelum.fj91.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import sun.org.mozilla.javascript.internal.NativeArray;

public class Programa {
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        
        NativeArray array = (NativeArray)engine.eval("new Array(1.1, 9.0, 4.7, 5.33)");
        
        System.out.println("Tamanho do array: " + array.getLength());
        
        System.out.println("Iterando no array e exibindo os elementos:");
        
        for(int i = 0; i < array.getLength(); i++) {
        	System.out.println(array.get(i, null));
        }
	}
}
