package com.lucasbarbosarocha.hexagonal.adapters.out.repository.mapper;

import com.lucasbarbosarocha.hexagonal.adapters.out.repository.entitiy.CustomerEntity;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-30T20:15:12-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public CustomerEntity toCustomerEntity(Customer Customer) {
        if ( Customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        return customerEntity;
    }

    @Override
    public Customer toCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }
}
