package com.lucasbarbosarocha.hexagonal.application.ports.out;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Address;

public interface FindAddressByZopCodeOutputPort {

    Address find(String zipCode);
}
