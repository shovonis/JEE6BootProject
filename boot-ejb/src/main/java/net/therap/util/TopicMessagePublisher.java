package net.therap.util;

import javax.ejb.Remote;

/**
 * @author rifatul.islam
 * @since 7/15/14.
 */

@Remote
public interface TopicMessagePublisher {
    public void publishNews(String message);
}