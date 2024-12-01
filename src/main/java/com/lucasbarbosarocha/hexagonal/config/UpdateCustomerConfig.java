package com.lucasbarbosarocha.hexagonal.config;

import com.lucasbarbosarocha.hexagonal.adapters.out.FindAddressByZipcodeAdapter;
import com.lucasbarbosarocha.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.lucasbarbosarocha.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.lucasbarbosarocha.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.lucasbarbosarocha.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipcodeAdapter findAddressByZipcodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipcodeAdapter, updateCustomerAdapter);
    }
}
