package com.lucasbarbosarocha.hexagonal.adapters.out.repository;

import com.lucasbarbosarocha.hexagonal.adapters.out.repository.entitiy.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
