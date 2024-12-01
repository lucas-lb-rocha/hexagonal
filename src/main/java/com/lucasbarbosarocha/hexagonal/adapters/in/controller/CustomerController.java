package com.lucasbarbosarocha.hexagonal.adapters.in.controller;

import com.lucasbarbosarocha.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.lucasbarbosarocha.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.lucasbarbosarocha.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.lucasbarbosarocha.hexagonal.application.core.domain.Customer;
import com.lucasbarbosarocha.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.lucasbarbosarocha.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        final var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final String id) {
        final var customer = findCustomerByIdInputPort.find(id);
        final var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final String id, @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
