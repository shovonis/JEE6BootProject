package net.therap.controller;

import net.therap.util.QueueMessageProducer;
import net.therap.util.TopicMessagePublisher;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author rifatul.islam
 * @since 7/15/14.
 */
@Named("messageController")
@RequestScoped
public class MessageController {
//    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private String queueMessage;
    private String topicMessage;

    @EJB
    private QueueMessageProducer queueMessageProducer;

    @EJB
    private TopicMessagePublisher topicMessagePublisher;

    public String getQueueMessage() {
        return queueMessage;
    }

    public void setQueueMessage(String queueMessage) {
        this.queueMessage = queueMessage;
    }

    public String getTopicMessage() {
        return topicMessage;
    }

    public void setTopicMessage(String topicMessage) {
        this.topicMessage = topicMessage;
    }

    public void sendQueueMessage() {

        queueMessageProducer.send(queueMessage);
    }

    public void sendTopicMessage() {
        topicMessagePublisher.publishNews(topicMessage);
    }
}
