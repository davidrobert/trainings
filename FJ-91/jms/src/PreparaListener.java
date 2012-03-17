import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PreparaListener {
	public static void main(String[] args) throws JMSException, NamingException {
		InitialContext context = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		
		Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination caelum = (Destination) context.lookup("caelum");
		
		MessageConsumer consumer = s.createConsumer(caelum);
		consumer.setMessageListener(new CaelumListener());
		connection.start();
	}
}
