package net.therap.controller;

import net.therap.service.impl.GlobalCounterService;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author rifatul.islam
 * @since 7/9/14.
 */

@ManagedBean
@ApplicationScoped
public class SingletonCounterController {
    @EJB
    private GlobalCounterService globalCounter;

    private int counterValue;


    public void incrementCounter() {
        globalCounter.incrementGlobalCounter();
    }

    public int getCounterValue() {
        counterValue = globalCounter.getGlobalCounter();
        return counterValue;
    }

    public void setCounterValue(int counter) {
        this.counterValue = counter;
    }

}
