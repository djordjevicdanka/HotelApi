package com.example.guestrecordsapi.repository;
import com.example.guestrecordsapi.dto.GuestResponse;
import com.example.guestrecordsapi.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    @Query("SELECT new com.example.guestrecordsapi.dto.GuestResponse(h.name, g.guest_id, g.name, g.surname, g.phone) FROM Guest g JOIN g.hotel h")

    List<GuestResponse> findAllGuests();


    @Query("SELECT new com.example.guestrecordsapi.dto.GuestResponse(h.name, g.guest_id, g.name, g.surname, g.phone) FROM Guest g JOIN g.hotel h WHERE guest_id=2")

    List<GuestResponse> findGuestById();

}

