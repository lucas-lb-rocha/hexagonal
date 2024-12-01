package com.lucasbarbosarocha.hexagonal.application.ports.in;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
