package com.myhotel.reservationms.controller;

import com.myhotel.reservationms.entity.Reservation;
import com.myhotel.reservationms.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservationms")
public class ReservationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        logger.info("Getting all reservations");
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/roomtype/{roomtype}")
    public List<Reservation> getReservationByRoomType(@PathVariable ("roomtype") String roomType) {
        logger.info("Getting all reservations with roomtype: " + roomType);
        return reservationService.getReservationByRoomType(roomType);
    }

    @GetMapping("/reservation/{email}")
    public List<Reservation> getReservation(@PathVariable ("email") String email) {
        logger.info("Getting all reservations with email: " + email);
        return reservationService.getReservationByEmail(email);
    }

    @PostMapping("/reservation")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        logger.info("Request for createReservation " + reservation);
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        logger.info("Request for updateReservation " + reservation);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/reservation/{email}")
    public void deleteReservationByEmail(@PathVariable ("email") String email) {
        logger.info("Deleting all reservations with email: " + email);
        reservationService.deleteAllReservationByEmail(email);
    }

    @DeleteMapping("/reservation/{email}/id/{id}")
    public void deleteReservationByEmailAndId(@PathVariable ("email") String email,
                                              @PathVariable ("id") String id) {
        logger.info("Deleting all reservations with email: " + email + " and id : " + id);
        reservationService.deleteAllReservationByEmailAndId(email, id);
    }

}
