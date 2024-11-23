package com.heraj.sgx_pub_sub.controller;

import com.heraj.sgx_pub_sub.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String topic, @RequestParam String data) {
        publisherService.publish(topic, data);
        return ResponseEntity.ok("Event published");
    }
}

