package com.heraj.sgx_pub_sub.repository;


import com.heraj.sgx_pub_sub.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    List<Subscriber> findByTopic(String topic);
}

