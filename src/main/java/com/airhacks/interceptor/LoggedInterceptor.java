package com.airhacks.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggedInterceptor {

    @AroundInvoke
    public Object Logthis(InvocationContext invocationContext) throws Exception {
        System.out.println("Interceptor Logging call");
        return invocationContext.proceed();
    }

}
