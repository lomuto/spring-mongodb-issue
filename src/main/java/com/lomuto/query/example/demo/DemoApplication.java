package com.lomuto.query.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     *  Create collection user if absent for test
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initMongoTemplate() {
        if (mongoTemplate.collectionExists(User.class)) {
            return;
        }
        mongoTemplate.createCollection(User.class);
    }
}
