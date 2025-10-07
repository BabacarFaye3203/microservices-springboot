package com.babacar.app.dto.responses;

import lombok.Builder;

@Builder
public record CreateCustomerResponse(
        String uuid,
        String name,
        String adress,
        String email
) {
}
