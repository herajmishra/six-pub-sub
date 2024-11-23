package com.heraj.sgx_pub_sub.listener;

import com.heraj.sgx_pub_sub.entity.Subscriber;
import com.heraj.sgx_pub_sub.event.EventPublishedEvent;
import com.heraj.sgx_pub_sub.service.SubscriberService;
import com.heraj.sgx_pub_sub.sgx.SGXHost;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventPublishedListener {
    private final SubscriberService subscriberService;
    private final SGXHost sgxHost;

    public EventPublishedListener(SubscriberService subscriberService, SGXHost sgxHost) {
        this.subscriberService = subscriberService;
        this.sgxHost = sgxHost;
    }

    @EventListener
    public void handleEventPublished(EventPublishedEvent event) {
        List<Subscriber> subscribers = subscriberService.getSubscribers(event.getTopic());
        for (Subscriber subscriber : subscribers) {
            String decryptedData = sgxHost.decrypt(event.getEncryptedData());
            System.out.println("Notifying " + subscriber.getName() + ": " + decryptedData);
        }
    }
}

