package com.babacar.app.services;

import com.babacar.app.dto.requests.CreateCustomerRequest;
import com.babacar.app.dto.responses.CreateCustomerResponse;
import com.babacar.app.entities.Customer;
import com.babacar.app.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {

        Customer customer = customerRepository.findByEmail(request.email());

        if (customer != null) {
            return new CreateCustomerResponse(customer.getUuid(), customer.getName(), customer.getAddress(), customer.getEmail());
        }
        customer = new Customer();
        customer.setUuid(UUID.randomUUID().toString());
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAddress(request.adress());
        customerRepository.save(customer);
        return new CreateCustomerResponse(customer.getUuid(),customer.getName(),customer.getAddress(),customer.getEmail());

    }

    public CreateCustomerResponse findCustomerByUuid(String uuid) {
        Customer customer=customerRepository.findByUuid(uuid);
        if (customer==null){
            return null;
        }
        return new CreateCustomerResponse(customer.getUuid(),customer.getName(),customer.getAddress(),customer.getEmail());
    }
}
