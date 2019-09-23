package com.airhacks.util;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TextUtil {

    public String capitalize(String text){
        return text.toUpperCase();
    }

    public String removeSpaces(String text){
        return text.replace("  "," ");
    }
}
