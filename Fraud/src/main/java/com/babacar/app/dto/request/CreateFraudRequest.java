package com.babacar.app.dto.request;

public record CreateFraudRequest(
        String customer_id,
        boolean isFraud
) {
}
