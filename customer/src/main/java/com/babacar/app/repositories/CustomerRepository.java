package com.babacar.app.repositories;

import com.babacar.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String email);
    Customer findByUuid(String uuid);
}
