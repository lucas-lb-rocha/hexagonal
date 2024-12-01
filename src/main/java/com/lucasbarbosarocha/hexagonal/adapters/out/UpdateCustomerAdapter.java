package com.lucasbarbosarocha.hexagonal.adapters.out;

import com.lucasbarbosarocha.hexagonal.adapters.out.repository.CustomerRepository;
import com.lucasbarbosarocha.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import com.lucasbarbosarocha.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
