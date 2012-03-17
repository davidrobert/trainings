package br.com.caelum.fj91.loader;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class LoaderModificado extends ClassLoader {

	public LoaderModificado() {
		super(null);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			System.out.println("lendo classe e interceptando: " + name);
			CtClass clazz = ClassPool.getDefault().get(name);

			for (CtMethod method : clazz.getMethods()) {
				// evitando a Object!
				if (method.getDeclaringClass().equals(clazz)) {
					method.insertBefore("{ System.out.println(\"metodo "
							+ method.getName() + " esta sendo invocado\"); }");
				}
			}

			byte[] b = clazz.toBytecode();
			return defineClass(name, b, 0, b.length);
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException();
	}
}
