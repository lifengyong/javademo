package com.neu.lify.console.orange;

import org.springframework.stereotype.Component;

@Component
public class BigOrange {
    public String getOrangeColor() {
        System.out.println("orange color yellow");
        return "yellow";
    }
}
