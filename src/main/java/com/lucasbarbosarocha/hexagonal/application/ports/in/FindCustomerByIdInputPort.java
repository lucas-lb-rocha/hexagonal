package com.lucasbarbosarocha.hexagonal.application.ports.in;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
