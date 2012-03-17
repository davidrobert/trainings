package br.com.caelum.fj91.transformer;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import javassist.ByteArrayClassPath;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class JavassistTransformer implements ClassFileTransformer {

	private final ClassPool pool = ClassPool.getDefault();
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		try {

			// ignora classes de terceiros
			if(!className.startsWith("br")) {
				return null;
			}

			className = className.replace('/', '.');
			// System.out.println("Preparando para transformar " + className);
			pool.insertClassPath(new ByteArrayClassPath(className, classfileBuffer));
			CtClass cc = pool.get(className);

			for(CtMethod method : cc.getMethods()) {
				if(method.getDeclaringClass().equals(cc)) {
					method.insertBefore("{ System.out.println(\"metodo " + method.getName() + " esta sendo invocado\"); }");
				}
			}

			return cc.toBytecode();

		} catch (NotFoundException e) {
			throw new IllegalClassFormatException(e.getMessage());
		} catch (CannotCompileException e) {
			throw new IllegalClassFormatException(e.getMessage());
		} catch (IOException e) {
			throw new IllegalClassFormatException(e.getMessage());
		}
	}

	public static void premain(String agentArgs, Instrumentation inst) {
		System.out.println("Premain");
		inst.addTransformer(new JavassistTransformer());
	}

}
