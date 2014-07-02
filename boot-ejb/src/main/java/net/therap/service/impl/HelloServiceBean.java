package net.therap.service.impl;

import net.therap.dao.HelloDao;
import net.therap.domain.User;
import net.therap.service.HelloService;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 6/30/14.
 */
@Stateless(name = "HelloEJB")
public class HelloServiceBean implements HelloService {

    @EJB
    private HelloDao helloDao;

    public HelloServiceBean() {
    }

    public String sayHello() {
        return helloDao.sayHello();
    }

    @Asynchronous
    public Future<String> asynchTask() {
        return helloDao.asynchTask();
    }

    @Override
    public User testQuery() {
        return helloDao.testQuery();
    }
}
