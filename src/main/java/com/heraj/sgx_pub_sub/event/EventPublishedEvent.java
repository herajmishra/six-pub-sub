package com.heraj.sgx_pub_sub.event;

import org.springframework.context.ApplicationEvent;

public class EventPublishedEvent extends ApplicationEvent {

    private final String topic;           // The topic to which the event was published
    private final String encryptedData;   // The encrypted event data

    // Constructor to initialize the event
    public EventPublishedEvent(Object source, String topic, String encryptedData) {
        super(source);                     // Call the parent constructor with the event source
        this.topic = topic;
        this.encryptedData = encryptedData;
    }

    // Getters for topic and encrypted data
    public String getTopic() {
        return topic;
    }

    public String getEncryptedData() {
        return encryptedData;
    }
}

