package com.heraj.sgx_pub_sub.repository;

import com.heraj.sgx_pub_sub.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}

