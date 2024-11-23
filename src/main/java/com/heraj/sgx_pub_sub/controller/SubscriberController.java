package com.heraj.sgx_pub_sub.controller;

import com.heraj.sgx_pub_sub.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriberController {
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam String name, @RequestParam String topic,
                                            @RequestParam String constraint) {
        subscriberService.subscribe(name, topic, constraint);
        return ResponseEntity.ok("Subscribed successfully");
    }
}

