package com.lucasbarbosarocha.hexagonal.application.ports.in;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
