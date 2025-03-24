package com.example.demo.eventHandling;

import org.springframework.boot.CommandLineRunner;

public class EventDemo implements CommandLineRunner {
    private final OrderService orderService;

    public EventDemo(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.createOrder("123");
    }
}
