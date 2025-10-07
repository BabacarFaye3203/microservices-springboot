package com.babacar.app.dto.requests;

public record CreateCustomerRequest(
        String name,
        String email,
        String adress
) {
}
