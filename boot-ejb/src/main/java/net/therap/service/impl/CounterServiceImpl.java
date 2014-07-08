package net.therap.service.impl;

import net.therap.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.concurrent.TimeUnit;

/**
 * @author rifatul.islam
 * @since 7/8/14.
 */


@Stateful(name = "CounterEJB")
@StatefulTimeout(unit = TimeUnit.SECONDS, value = 20)
public class CounterServiceImpl implements CounterService {
    private static final Logger log = LoggerFactory.getLogger(CounterServiceImpl.class);

    private int counter;

    private int tmpCounter;

    @PostConstruct
    private void initialize() {
        counter = 0;
        log.info("CounterService Initialized Counter = " + counter);
    }

    public CounterServiceImpl() {
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void incrementCounter() {
        counter++;
        log.info("Counter Incremented. Counter = " + counter);
    }

    @PrePassivate
    public void setCounterToFive() {
        tmpCounter = counter;
        counter = 0;
        log.info("Counter is going to passive state. And Value is set to 0.Counter = " + counter);
    }

    @PostActivate
    public void activateCounter() {
        counter = tmpCounter;
        log.info("Counter is in Active state.Counter value is set to previous state. Counter = " + counter);
    }

    // Client can call only this method of the stateful bean life cycle.
    // Other method are handled by the container.
    @Override
    @Remove
    public void removeCounter() {
        log.info("Client invoked the removeCounter Method.Counter is being destroyed. Counter = " + counter);
    }

    @PreDestroy
    public void reset() {
        counter = 0;
        tmpCounter = 0;
        log.info("Counter is destroyed.Counter = " + counter);
    }
}
