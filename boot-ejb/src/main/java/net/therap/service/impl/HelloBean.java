package net.therap.service.impl;

import net.therap.domain.User;
import net.therap.service.Hello;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 6/30/14.
 */
@Stateless(name = "HelloEJB")
public class HelloBean implements Hello {

    @PersistenceContext(unitName = "persistDB")
    EntityManager entityManager;

    public HelloBean() {
    }


    public String sayHello() {
        return "Hello JEE 6 ";
    }

    @Asynchronous
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
