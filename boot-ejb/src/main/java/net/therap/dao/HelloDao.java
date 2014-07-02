package net.therap.dao;

import net.therap.domain.User;

import javax.ejb.Local;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 6/30/14.
 */

@Local
public interface HelloDao {
    public String sayHello();

    public Future<String> asynchTask();

    public User testQuery();

}