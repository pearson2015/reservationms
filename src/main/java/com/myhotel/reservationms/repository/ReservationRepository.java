package com.myhotel.reservationms.repository;

import com.myhotel.reservationms.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    public List<Reservation> findByEmail(String email);

    public List<Reservation> findByRoomType(String roomType);

    public void deleteByEmail(String email);

    public void deleteByEmailAndId(String email, long id);

}
