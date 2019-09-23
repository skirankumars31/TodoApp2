package com.airhacks.ping.boundary;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

@Dependent
public class DepScoped {

    public int getHashCode() {
        return this.hashCode();
    }
}
