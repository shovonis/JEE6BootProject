package net.therap.util.impl;

import net.therap.util.TopicMessagePublisher;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 * @author rifatul.islam
 * @since 7/15/14.
 */

@Stateless
@Local(TopicMessagePublisher.class)
public class TopicMessagePublisherImpl implements TopicMessagePublisher {

    @Resource(mappedName = "jms/bootJmsConnectionFactory")
    private ConnectionFactory connectionFactory;

    private TopicConnection topicConnection;

    @Resource(mappedName = "jms/bootTopic")
    private Topic topic;

    @Inject
    private TopicSession session;

    @Override
    public void publishNews(String message) {
        try {
            topicConnection = (TopicConnection) connectionFactory.createConnection();
            session = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher topicPublisher = session.createPublisher(topic);
            topicPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            topicPublisher.publish(textMessage);

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                topicConnection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
