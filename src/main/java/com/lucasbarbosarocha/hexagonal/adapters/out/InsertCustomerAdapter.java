package com.lucasbarbosarocha.hexagonal.adapters.out;

import com.lucasbarbosarocha.hexagonal.adapters.out.repository.CustomerRepository;
import com.lucasbarbosarocha.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import com.lucasbarbosarocha.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));

    }
}
