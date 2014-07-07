package net.therap.service.impl;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 7/7/14.
 */
@Stateless(name = "UserServiceEJB")
@Local(UserService.class)
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @EJB
    private UserDao userDao;

    @PostConstruct
    public void setUp() {
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
    public void tearDown() {
        log.info("UserServiceImpl PreDestroy Invoked");
    }
}