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

}
