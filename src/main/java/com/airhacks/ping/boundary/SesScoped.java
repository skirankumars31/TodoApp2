package com.airhacks.ping.boundary;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SesScoped implements Serializable {

    public int getHashCode(){
        return this.hashCode();
    }

}
