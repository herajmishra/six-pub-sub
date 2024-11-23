package com.heraj.sgx_pub_sub.service;

import com.heraj.sgx_pub_sub.entity.Subscriber;
import com.heraj.sgx_pub_sub.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public void subscribe(String name, String topic, String constraint) {
        Subscriber subscriber = new Subscriber();
        subscriber.setName(name);
        subscriber.setTopic(topic);
        subscriber.setEncryptedConstraint(constraint);
        subscriberRepository.save(subscriber);
    }

    public List<Subscriber> getSubscribers(String topic) {
        return subscriberRepository.findByTopic(topic);
    }
}

