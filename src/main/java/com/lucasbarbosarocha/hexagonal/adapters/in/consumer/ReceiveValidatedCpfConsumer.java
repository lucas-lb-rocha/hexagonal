package com.lucasbarbosarocha.hexagonal.adapters.in.consumer;

import com.lucasbarbosarocha.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.lucasbarbosarocha.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.lucasbarbosarocha.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private UpdateCustomerInputPort updateCustomerInputPort;
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "brocha")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
