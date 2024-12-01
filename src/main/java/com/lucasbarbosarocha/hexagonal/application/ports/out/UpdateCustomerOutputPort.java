package com.lucasbarbosarocha.hexagonal.application.ports.out;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
