package net.therap.controller;

import net.therap.service.CounterService;
import net.therap.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 7/8/14.
 */

@ManagedBean(name = "counterController")
@SessionScoped
public class CounterController {
    @EJB
    private CounterService counterService;

    @EJB
    private UserService userService;

    private String asyncString;

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


    public String asyncMessage() {
        Future<String> result = userService.getAsyncMessage();
        if (result.isDone()) {
            try {
                this.setAsyncString(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            this.setAsyncString("Processing...");
        }
        return "cart.xhtml?faces-redirect=true";
    }

    public String getAsyncString() {
        return asyncString;
    }

    public void setAsyncString(String asyncString) {
        this.asyncString = asyncString;
    }

}
