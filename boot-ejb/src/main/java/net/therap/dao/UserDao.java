package net.therap.dao;


import net.therap.domain.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/20/14
 * Time: 12:01 PM
 */

@Local
public interface UserDao {
    public User getUser(String userName, String password);

    public List<User> getAllUser();

    public void addUser(User user);
}
