package com.babacar.app.dto.responses;

import lombok.Builder;

@Builder
public record CheckFraudsterResponse(boolean isFraudster) {
}
