package net.therap.service;

/**
 * @author rifatul.islam
 * @since 7/8/14.
 */
public interface CounterService {
    public void incrementCounter();

    public void removeCounter();

    public int getCounter();

    public void setCounter(int counter);
}
