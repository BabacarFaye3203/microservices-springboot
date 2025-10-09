package com.babacar.app.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "fraud")
public class Fraud {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(name = "uuid")
     private String uuid;
     @Column(name = "isfraud")
     private boolean isFraud;
     @Column(name = "customer_id")
     private String customer_id;
     @Column(name = "date_time")
     private LocalDateTime dateTime;
}
