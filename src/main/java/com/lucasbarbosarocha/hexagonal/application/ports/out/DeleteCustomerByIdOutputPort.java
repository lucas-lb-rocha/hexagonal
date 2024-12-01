package com.lucasbarbosarocha.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    void delete(String id);
}
