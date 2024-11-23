package com.heraj.sgx_pub_sub.entity;

import jakarta.persistence.*;

@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String topic;

    public String getEncryptedConstraint() {
        return encryptedConstraint;
    }

    public void setEncryptedConstraint(String encryptedConstraint) {
        this.encryptedConstraint = encryptedConstraint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private String encryptedConstraint;

    // Getters and setters
}

