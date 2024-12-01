package com.lucasbarbosarocha.hexagonal.application.core.usecase;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import com.lucasbarbosarocha.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.out.FindAddressByZopCodeOutputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZopCodeOutputPort findAddressByZopCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZopCodeOutputPort findAddressByZopCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZopCodeOutputPort = findAddressByZopCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZopCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
