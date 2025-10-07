package com.babacar.app.controller;

import com.babacar.app.dto.requests.CreateCustomerRequest;
import com.babacar.app.dto.responses.CreateCustomerResponse;
import com.babacar.app.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Customer APIs")
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    @Operation(summary="create customer")
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request){
        return customerService.createCustomer(request);
    }

    @GetMapping("/{uuid}")
    @Operation(summary="get customer by uuid")
    public CreateCustomerResponse findCustomer(@PathVariable("uuid") String uuid){
        return customerService.findCustomerByUuid(uuid);
    }
}
