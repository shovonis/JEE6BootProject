package net.therap.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author rifatul.islam
 * @since 7/9/14.
 */

public class SimpleProfiler {
    private static final Logger log = LoggerFactory.getLogger(SimpleProfiler.class);

    private long startTime;
    private long endTime;

    @AroundInvoke
    public Object calculateTime(InvocationContext invocationContext) throws Exception {
        startTime = System.currentTimeMillis();
        log.info(invocationContext.getMethod().getName() + " Method Intercepted at time " + startTime);
        try {
            return invocationContext.proceed();
        } finally {
            endTime = System.currentTimeMillis();
            log.info(invocationContext.getMethod().getName() + "Interception Finished " + endTime);
            log.info("Total Time needed for " + invocationContext.getMethod().getName() +
                    " to execute is " + (endTime - startTime) + "msec");
        }

    }
}
