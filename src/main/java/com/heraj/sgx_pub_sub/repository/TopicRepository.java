package com.heraj.sgx_pub_sub.repository;

import com.heraj.sgx_pub_sub.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {}

