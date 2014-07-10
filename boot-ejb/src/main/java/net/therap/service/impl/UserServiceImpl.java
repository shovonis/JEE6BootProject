package net.therap.service.impl;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 7/7/14.
 */
@Stateless(name = "UserServiceEJB")
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @EJB
    private UserDao userDao;

    @PostConstruct
    public void initialize() {
        log.info("UserServiceImpl PostConstruct Invoked");
    }

    public UserServiceImpl() {
    }

    @Override
    public User getUser(String userName, String password) {
        log.info("getUser Method Invoked");
        return userDao.getUser(userName, password);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @PreDestroy
    public void destroy() {
        log.info("UserServiceImpl PreDestroy Invoked");
    }

    @Schedule(hour = "*", minute = "*")
    public void logTimer() {
        log.info(" log timer Method from invoked at every minute");
    }

    @Asynchronous
    public Future<String> getAsyncMessage() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>("Hello Message");
    }
}
