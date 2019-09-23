package com.airhacks.ping.boundary;

import com.airhacks.interceptor.Logged;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author airhacks.com
 */

@RequestScoped
@Named
public class PingResource {

    @Inject
    private DepScoped depScoped;

    @Inject
    private SesScoped sesScoped;

    @Inject
    private AppScoped appScoped;

    @Logged
    public String getReqHashCode(){
        return " Jakarta EE with MicroProfile 2+!! with hashcode "+depScoped.getHashCode();
    }

    public String getSesHashCode(){
        return "The hashcode from the session scope is "+sesScoped.getHashCode();
    }

    public String getAppHashCode(){
        return "The hashcode from the application scope is "+appScoped.getHashCode();
    }

}