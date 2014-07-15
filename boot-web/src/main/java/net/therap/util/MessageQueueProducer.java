package net.therap.util;

import net.therap.util.TopicMessagePublisher;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.jms.*;

/**
 * @author rifatul.islam
 * @since 7/14/14.
 */

@Named(value = "messageProducerBean")
@RequestScoped
public class MessageQueueProducer {
    private String message;

    @Resource(mappedName = "jms/bootJmsConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/bootQueue")
    private Queue queue;

    @EJB
    private TopicMessagePublisher remoteTopic;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void send() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            produceMessages(message);
            FacesMessage facesMessage = new FacesMessage("Message sent: " + message);
            facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
            facesContext.addMessage(null, facesMessage);
        } catch (JMSException error) {
            FacesMessage facesMessage = new FacesMessage("Message NOT sent: " + message);
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
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


    public void topicMessage() {
        remoteTopic.publishNews(message);
    }
}
