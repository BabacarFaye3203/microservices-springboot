package com.babacar.app.controllers;

import com.babacar.app.dto.request.CreateFraudRequest;
import com.babacar.app.dto.responses.CheckFraudsterResponse;
import com.babacar.app.dto.responses.FraudResponse;
import com.babacar.app.services.FraudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fraud")
@Tag(name = "Fraud API")
@RequiredArgsConstructor
public class FraudController {
    private final FraudService fraudService;

    @GetMapping("/{customer_uuid}")
    @Operation(summary = "check if a fraud")
    public CheckFraudsterResponse createFraud(
            @PathVariable("customer_uuid") String customer_uuid){
        return fraudService.checkFraud(customer_uuid);
    }

}
