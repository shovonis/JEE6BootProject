package net.therap.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

/**
 * @author rifatul.islam
 * @since 7/8/14.
 */

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class GlobalCounterService {
    private static final Logger log = LoggerFactory.getLogger(GlobalCounterService.class);
    private int globalCounter;


    @PostConstruct
    public void initialize() {
        globalCounter = 0;
        log.info("Singleton Counter is Initialized Counter is " + globalCounter);
    }

    @Lock(LockType.WRITE)
    public synchronized void incrementGlobalCounter() {
        globalCounter++;
        log.info("Singleton Counter is incremented.Counter = " + globalCounter);
    }


    @Lock(LockType.READ)
    public int getGlobalCounter() {
        return globalCounter;
    }

    @PreDestroy
    public void destroy() {
        log.info("Singleton Counter Bean is destroyed");
    }
}
