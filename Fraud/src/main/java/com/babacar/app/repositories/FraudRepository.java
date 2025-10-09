package com.babacar.app.repositories;

import com.babacar.app.entities.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FraudRepository extends JpaRepository<Fraud,Long> {

    Optional<Fraud>  findByUuid(String uuid);
}
