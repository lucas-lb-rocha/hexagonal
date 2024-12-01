package com.lucasbarbosarocha.hexagonal.adapters.out.client.mapper;

import com.lucasbarbosarocha.hexagonal.adapters.out.client.response.AddressResponse;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-30T20:15:13-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class AddressResponseMapperImpl implements AddressResponseMapper {

    @Override
    public Address toAddress(AddressResponse addressResponse) {
        if ( addressResponse == null ) {
            return null;
        }

        String street = null;

        Address address = new Address( street );

        return address;
    }
}
