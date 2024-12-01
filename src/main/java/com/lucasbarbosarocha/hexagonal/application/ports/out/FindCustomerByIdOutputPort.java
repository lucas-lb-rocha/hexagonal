package com.lucasbarbosarocha.hexagonal.application.ports.out;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
