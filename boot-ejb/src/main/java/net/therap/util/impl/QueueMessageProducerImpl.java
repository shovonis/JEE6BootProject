package net.therap.util.impl;

import net.therap.util.QueueMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 * @author rifatul.islam
 * @since 7/15/14.
 */
@Stateless
@Local(QueueMessageProducer.class)
public class QueueMessageProducerImpl implements QueueMessageProducer {
    private static final Logger log = LoggerFactory.getLogger(QueueMessageProducerImpl.class);
    @Resource(mappedName = "jms/bootJmsConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/bootQueue")
    private Queue queue;

    @Override
    public void send(String message) {
        try {
            produceMessages(message);
        } catch (JMSException error) {
        }
    }

    private Message createJMSFactoryMessage(Session session, Object messageData) throws JMSException {

        TextMessage textMessage = session.createTextMessage();
        textMessage.setText(messageData.toString());

        return textMessage;
    }

    public void produceMessages(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;

        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.send(createJMSFactoryMessage(session, messageData));

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
