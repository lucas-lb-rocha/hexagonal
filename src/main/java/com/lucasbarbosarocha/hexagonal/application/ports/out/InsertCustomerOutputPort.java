package com.lucasbarbosarocha.hexagonal.application.ports.out;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
