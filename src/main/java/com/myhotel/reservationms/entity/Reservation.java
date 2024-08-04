package com.myhotel.reservationms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String roomNumber;
    private String roomType;
    private Date reservationDate;
    private String reservationStatus;
    private double price;
    private String paymentTransactionId;
}
