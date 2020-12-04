package com.example.guestrecordsapi.repository;
import com.example.guestrecordsapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
