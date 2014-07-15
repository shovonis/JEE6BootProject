package net.therap.util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author rifatul.islam
 * @since 7/15/14.
 */
@MessageDriven(mappedName = "jms/bootTopic", activationConfig =  {
        @ActivationConfigProperty(propertyName = "subscriptionDurability",
                propertyValue = "Durable")
        , @ActivationConfigProperty(propertyName = "clientId",
        propertyValue = "MyID")
        , @ActivationConfigProperty(propertyName = "subscriptionName",
        propertyValue = "MySub")
})
public class TopicMessageConsumer2 implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(TopicMessageConsumer.class);

    public TopicMessageConsumer2() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage meg = (TextMessage) message;
        try {
            log.info("Consumed Message From 2 :  " + meg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
