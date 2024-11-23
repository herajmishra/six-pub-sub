package com.heraj.sgx_pub_sub.service;

import com.heraj.sgx_pub_sub.entity.Event;
import com.heraj.sgx_pub_sub.event.EventPublishedEvent;
import com.heraj.sgx_pub_sub.repository.EventRepository;
import com.heraj.sgx_pub_sub.sgx.SGXHost;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final EventRepository eventRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final SGXHost sgxHost;

    public PublisherService(EventRepository eventRepository, ApplicationEventPublisher eventPublisher, SGXHost sgxHost) {
        this.eventRepository = eventRepository;
        this.eventPublisher = eventPublisher;
        this.sgxHost = sgxHost;
    }

    public void publish(String topic, String data) {
        String encryptedData = sgxHost.encrypt(data);
        Event event = new Event();
        event.setTopic(topic);
        event.setEncryptedData(encryptedData);
        eventRepository.save(event);
        eventPublisher.publishEvent(new EventPublishedEvent(this, topic, encryptedData));
    }
}

