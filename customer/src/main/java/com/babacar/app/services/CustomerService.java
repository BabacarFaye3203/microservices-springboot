package com.babacar.app.services;

import com.babacar.app.dto.requests.CreateCustomerRequest;
import com.babacar.app.dto.responses.CheckFraudsterResponse;
import com.babacar.app.dto.responses.CreateCustomerResponse;
import com.babacar.app.entities.Customer;
import com.babacar.app.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

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
        customerRepository.saveAndFlush(customer);

        CheckFraudsterResponse response=restTemplate.getForObject(
                "http://FRAUD/fraud/{customer_uuid}",
                CheckFraudsterResponse.class,
                customer.getUuid()
        );
        if (response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
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
