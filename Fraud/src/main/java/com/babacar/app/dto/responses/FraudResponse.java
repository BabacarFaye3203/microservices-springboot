package com.babacar.app.dto.responses;

import lombok.Builder;

@Builder
public record FraudResponse(
        String uuid,
        String customer_id,
        boolean isFraud
) {
}
