package com.myhotel.reservationms.service;

import com.myhotel.reservationms.entity.Reservation;
import com.myhotel.reservationms.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        logger.info("Getting all reservations from service layer");
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(long id) {
        logger.info("Getting reservation with Id: " + id + " from service layer");
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> getReservationByEmail(String email) {
        logger.info("Getting all reservations with email: " + email + " from service layer");
        return reservationRepository.findByEmail(email);
    }

    public Reservation createReservation(Reservation reservation) {
        logger.info("Creating reservation: " + reservation + " from service layer");
        reservation.setReservationDate(new Date());
        reservation.setReservationStatus("RESERVED");
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        logger.info("Updating reservation: " + reservation + " from service layer");
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(long id) {
        logger.info("Deleting reservation with Id: " + id + " from service layer");
        reservationRepository.deleteById(id);
    }

    public void deleteAllReservationByEmail(String email) {
        logger.info("Deleting all reservations with email: " + email + " from service layer");
        reservationRepository.deleteByEmail(email);
    }

    public void deleteAllReservationByEmailAndId(String email, String id) {
        logger.info("Deleting all reservations with email: " + email
                + " and id: " + id + " from service layer");
        long longId =  Long.parseLong(id);
        reservationRepository.deleteByEmailAndId(email, longId);
    }

    public List<Reservation> getReservationByRoomType(String roomType) {
        logger.info("Getting all reservations with room type: " + roomType + " from service layer");
        return reservationRepository.findByRoomType(roomType);
    }

}
