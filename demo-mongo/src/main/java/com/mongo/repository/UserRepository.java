package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.entity.User;

public interface UserRepository extends MongoRepository<User, Integer> {

}
