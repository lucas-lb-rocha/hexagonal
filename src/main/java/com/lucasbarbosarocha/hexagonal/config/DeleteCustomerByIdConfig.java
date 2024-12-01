package com.lucasbarbosarocha.hexagonal.config;

import com.lucasbarbosarocha.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.lucasbarbosarocha.hexagonal.adapters.out.FindAddressByZipcodeAdapter;
import com.lucasbarbosarocha.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.lucasbarbosarocha.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.lucasbarbosarocha.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.lucasbarbosarocha.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
