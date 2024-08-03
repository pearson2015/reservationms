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
    private String roomType;
    private Date reservationDate;
    private Date checkInDate;
    private Date checkOutDate;
    private int numberOfRooms;
    private double amount;
}
