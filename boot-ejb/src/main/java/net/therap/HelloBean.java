package net.therap;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * @author rifatul.islam
 * @since 6/30/14.
 */
@Stateless(name = "HelloEJB")
public class HelloBean implements Hello {



    public HelloBean() {
    }


    public String sayHello() {
        return "hello";
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


}
