package br.com.caelum.fj91.classloader.listener;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Esse listener carrega milhares de classes no startup da aplicação 
 */
public class Inicializa implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
    	System.out.println("Inicializa o contexto...");
    	
    	// registra driver do mysql
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost/bla");
		} catch (Exception e) { }

    	// carrega 8000 classes no WebApp ClassLoader dessa aplicação
    	ClassLoader webappclassloader = Inicializa.class.getClassLoader();
    	try {
	    	for (int i = 1; i <= 5500; i++) {
				webappclassloader.loadClass("br.com.caelum.fj91.classloader.servlet.Classe" + i);
	    	}
    	} catch (ClassNotFoundException e) { }
    	
    	System.out.println("Fim da inicialização. Abra no navegador: http://localhost:8080/classloader-web/");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
//    	DEVEMOS DESREGISTRAR 
//    	
//    	try {
//			DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
    }
	
}
