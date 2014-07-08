package net.therap.service.impl;

import javax.ejb.*;

/**
 * @author rifatul.islam
 * @since 7/8/14.
 */

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class GlobalCounter {
    private int globalCounter;


    @Lock(LockType.WRITE)
    public synchronized void incrementGlobalCounter() {
        globalCounter++;
    }


    @Lock(LockType.READ)
    public int getGlobalCounter() {
        return globalCounter;
    }
}
