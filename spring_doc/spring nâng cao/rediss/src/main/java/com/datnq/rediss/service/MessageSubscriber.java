package com.datnq.rediss.service;

import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
    public void onMessage(String message, String channel) {
        System.out.println("📥 Received message from channel [" + channel + "]: " + message);
    }
}
