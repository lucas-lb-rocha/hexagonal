package com.lucasbarbosarocha.hexagonal.adapters.out.repository.mapper;

import com.lucasbarbosarocha.hexagonal.adapters.out.repository.entitiy.CustomerEntity;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer Customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
