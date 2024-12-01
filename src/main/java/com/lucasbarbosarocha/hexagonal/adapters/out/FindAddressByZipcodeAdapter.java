package com.lucasbarbosarocha.hexagonal.adapters.out;

import com.lucasbarbosarocha.hexagonal.adapters.out.client.FindAddressByZipcodeClient;
import com.lucasbarbosarocha.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Address;
import com.lucasbarbosarocha.hexagonal.application.ports.out.FindAddressByZopCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipcodeAdapter  implements FindAddressByZopCodeOutputPort {

    private final FindAddressByZipcodeClient findAddressByZipcodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipcodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
