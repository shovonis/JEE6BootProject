package net.therap.dao.impl;

import net.therap.dao.HelloDao;
import net.therap.domain.User;

import javax.ejb.AsyncResult;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 7/2/14.
 */
@Stateless(name = "HelloDaoEJB")
public class HelloDaoBean implements HelloDao {

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    public HelloDaoBean() {
    }

    public String sayHello() {
        return "Hello JEE 6 ";
    }


    public Future<String> asynchTask() {
        System.out.println("Asynchronous Task Begin");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Asynchronous Task Finished");

        return new AsyncResult<String>("Result Finished");

    }

    @Override
    public User testQuery() {
        return entityManager.find(User.class, 1);
    }
}
