package com.babacar.app.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    private String address;
    private String email;

}
