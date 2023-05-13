package com.lomuto.query.example.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/test")
    public void test() {
        var query = new Query().addCriteria(Criteria.where("_id").is(ObjectId.get().toString()));
        query.fields().include("_id", "name");
        query.with(Sort.by(Sort.Direction.ASC, "_id"));

        mongoTemplate.findOne(query, User.class, "user");
    }
}
