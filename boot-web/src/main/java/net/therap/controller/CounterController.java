package net.therap.controller;

import net.therap.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 * @author rifatul.islam
 * @since 7/8/14.
 */

@ManagedBean(name = "counterController")
@SessionScoped
public class CounterController {

    @EJB
    private CounterService counterService;

    private int counterValue;

    public void incrementCounter() {
        counterService.incrementCounter();
    }

    public void removeCounter() {
        counterService.removeCounter();
    }

    public int getCounterValue() {
        counterValue = counterService.getCounter();
        return counterValue;
    }

    public void setCounterValue(int counter) {
        this.counterValue = counter;
    }

}
