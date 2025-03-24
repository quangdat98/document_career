package com.example.demo.beandemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanPrototype {
    @Bean
    @Scope("prototype")
    public MyBean myBean() {
        return new MyBean();
    }




    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanPrototype.class);
        MyBean bean1 = context.getBean(MyBean.class);
        MyBean bean2 = context.getBean(MyBean.class);

        bean1.increment(); // Counter: 1
        bean2.increment(); // Counter: 1 (vì bean2 là instance mới)

        System.out.println("bean1 == bean2: " + (bean1 == bean2)); // false

        context.close();
    }
}

class MyBean {
    private int counter = 0;

    public void increment() {
        counter++;
        System.out.println("Counter: " + counter);
    }
}