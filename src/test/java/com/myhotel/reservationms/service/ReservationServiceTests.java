package com.myhotel.reservationms.service;

import com.myhotel.reservationms.entity.Reservation;
import com.myhotel.reservationms.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReservationServiceTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private ProducerService producerService;

    private static Reservation  reservation;

    @BeforeAll
    public static void setUp() {
        reservation = new Reservation(1L,
                "test@test.com",
                "L52",
                "1BHK",
                new Date(),
                "RERSERVED",
                100,
                UUID.randomUUID().toString());
    }

    @Test
    @DisplayName("Test to get all reservations")
    public void testGetAllReservations() {
        when(reservationRepository.findAll()).thenReturn(List.of(reservation));
        List<Reservation> reservations = reservationRepository.findAll();
        logger.info("Reservations: {}", reservations);
        assert !reservations.isEmpty();
        assert reservations.size() == 1;
    }

    @Test
    @DisplayName("Test to get reservation by id")
    public void testGetReservationById() {
        when(reservationRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(reservation));
        Reservation reservation = reservationRepository.findById(1L).get();
        logger.info("Reservation: {}", reservation);
        assert reservation.getId() == 1L;
    }

    @Test
    @DisplayName("Test to create reservation")
    public void testCreateReservation() {
        when(reservationRepository.save(reservation)).thenReturn(reservation);
        Reservation reservation1 = reservationRepository.save(reservation);
        logger.info("Reservation: {}", reservation1);
        assert reservation1.getId() == 1L;
    }

}
