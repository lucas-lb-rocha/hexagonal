package com.lucasbarbosarocha.hexagonal.application.core.usecase;

import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import com.lucasbarbosarocha.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.out.FindAddressByZopCodeOutputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.out.UpdateCustomerOutputPort;
public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZopCodeOutputPort findAddressByZopCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZopCodeOutputPort findAddressByZopCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZopCodeOutputPort = findAddressByZopCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZopCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
