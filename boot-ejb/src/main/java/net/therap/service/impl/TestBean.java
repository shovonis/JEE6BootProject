package net.therap.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * @author rifatul.islam
 * @since 7/2/14.
 */
@Stateless(name = "TestEJB")
public class TestBean {
    public TestBean() {
    }

    @PostConstruct
    public void sayHello() {
        System.out.println("Bean Initializing ...");
    }

    public void doTask() {
        System.out.println("Bean is doing task");
    }

    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Bean Destroying ...");
    }
}
