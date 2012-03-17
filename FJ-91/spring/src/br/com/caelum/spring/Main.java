package br.com.caelum.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		Menu menu = context.getBean(Menu.class);
		menu.showMenu();
	}
}
