package com.example.demo.eventHandling;

import org.springframework.context.ApplicationEventPublisher;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ApplicationEventPublisher eventPublisher;
    public OrderService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void createOrder(String orderId) {
        System.out.printf("Order created: %s\n", orderId);
        eventPublisher.publishEvent(new OrderCreatedEvent(this, orderId));
    }
}
