package br.com.caelum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import br.com.caelum.modelo.Produto;

@Aspect
public class PrintAspect {

	@Before("execution (* *.set*(..)) && this(produto)")
	public void antes(JoinPoint jp, Produto produto) throws Throwable {
		System.out.println("antes do setter");
	}

	@After("execution (* *.set*(..))")
	public void depois(JoinPoint jp) throws Throwable {
		System.out.println("depois do setter");
	}
	
	@Around("execution (public void *.set*(String)) && within( br.com.caelum.modelo.*)")
	public void around(ProceedingJoinPoint jp) throws Throwable {

		System.out.println("antes do setter");

		// continua
		jp.proceed();

		System.out.println("depois do setter");
	}
}
