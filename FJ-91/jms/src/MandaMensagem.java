import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MandaMensagem {

	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context
				.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		Session s = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();

		Destination caelum = (Destination) context.lookup("caelum");

		MessageProducer sender = s.createProducer(caelum);
		TextMessage message = s.createTextMessage("fj31 vendido!");
		
		sender.send(message);
	}
}
