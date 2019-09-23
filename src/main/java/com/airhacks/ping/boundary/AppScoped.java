package com.airhacks.ping.boundary;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppScoped {

    public int getHashCode(){
        return this.hashCode();
    }

}
