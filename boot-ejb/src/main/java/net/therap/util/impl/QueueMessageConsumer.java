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
 * @since 7/14/14.
 */
@MessageDriven(mappedName = "jms/bootQueue",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "acknowledgeMode",
                        propertyValue = "Auto-acknowledge"),
                @ActivationConfigProperty(propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue")
        })
public class QueueMessageConsumer implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(QueueMessageConsumer.class);

    public QueueMessageConsumer() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            log.info("Consumed Message : " + textMessage.getText());
        } catch (JMSException e) {
            
        }
    }
}
