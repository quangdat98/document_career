package com.example.demo.eventHandling;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("order received: " + orderCreatedEvent);
    }
}
