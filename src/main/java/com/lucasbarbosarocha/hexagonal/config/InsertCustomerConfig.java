package com.lucasbarbosarocha.hexagonal.config;

import com.lucasbarbosarocha.hexagonal.adapters.out.FindAddressByZipcodeAdapter;
import com.lucasbarbosarocha.hexagonal.adapters.out.InsertCustomerAdapter;
import com.lucasbarbosarocha.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.lucasbarbosarocha.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipcodeAdapter findAddressByZipcodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter) {
        return new InsertCustomerUseCase(findAddressByZipcodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
