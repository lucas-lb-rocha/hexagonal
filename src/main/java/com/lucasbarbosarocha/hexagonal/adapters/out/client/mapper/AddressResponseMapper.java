package com.lucasbarbosarocha.hexagonal.adapters.out.client.mapper;

import com.lucasbarbosarocha.hexagonal.adapters.out.client.response.AddressResponse;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
