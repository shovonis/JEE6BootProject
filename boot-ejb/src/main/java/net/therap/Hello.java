package net.therap;

import javax.ejb.Local;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 6/30/14.
 */

@Local
public interface Hello {
    public String sayHello();

    public Future<String> asynchTask();


}
