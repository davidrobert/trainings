package br.com.caelum.fj91.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteJavaAssistViaClassLoader {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		LoaderModificado loader = new LoaderModificado();
		Class<?> clazz = loader.loadClass("br.com.caelum.fj91.loader.ObjetoTeste");
		Method m = clazz.getDeclaredMethod("teste");
		Object o1 = clazz.newInstance();
		m.invoke(o1);
	}
}
