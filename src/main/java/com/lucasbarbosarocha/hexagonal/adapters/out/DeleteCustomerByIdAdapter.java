package com.lucasbarbosarocha.hexagonal.adapters.out;

import com.lucasbarbosarocha.hexagonal.adapters.out.repository.CustomerRepository;
import com.lucasbarbosarocha.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
