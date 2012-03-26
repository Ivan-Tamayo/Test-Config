package net.ivantamayo.springtraining;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServiceInvocationLogger {
 
    private int invocationCount;
 
    @Pointcut("execution(* net.ivantamayo.springtraining.*Service*.*(...))")
    public void serviceInvocation() {}
 
    @Before("serviceInvocation()")
    public void log() {
        invocationCount++;
        System.out.println("service invocation #" + invocationCount);
    }
}