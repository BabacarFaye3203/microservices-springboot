package com.babacar.app.services;

import com.babacar.app.dto.request.CreateFraudRequest;
import com.babacar.app.dto.responses.CheckFraudsterResponse;
import com.babacar.app.entities.Fraud;
import com.babacar.app.repositories.FraudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public CheckFraudsterResponse checkFraud(String customer_uuid){
        Fraud fraud=new Fraud();
        fraud.setUuid(UUID.randomUUID().toString());
        fraud.setCustomer_id(customer_uuid);
        fraud.setFraud(false);
        fraud.setDateTime(LocalDateTime.now());

        fraudRepository.save(fraud);
        return new CheckFraudsterResponse(fraud.isFraud());

    }




}
