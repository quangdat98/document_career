package com.example.demo.beandemo;

import org.springframework.stereotype.Component;

@Component
public class BeanSingleton {
    public BeanSingleton() {
        System.out.println("init BeanSingleton!!");
    }
}
