package net.therap.service;

import net.therap.domain.User;

import javax.ejb.Local;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 7/7/14.
 */

@Local
public interface UserService {
    public User getUser(String userName, String password);

    public List<User> getAllUser();

    public void addUser(User user);

    public Future<String> getAsyncMessage();
}
