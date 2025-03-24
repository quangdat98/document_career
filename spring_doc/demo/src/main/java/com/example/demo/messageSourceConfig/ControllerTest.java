package com.example.demo.messageSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ControllerTest {

    @Autowired
    private MessageSource messageSource;

    public String getGreeting(String name, Locale locale) {
        return messageSource.getMessage("param_1", new Object[]{name}, locale);
    }
}
