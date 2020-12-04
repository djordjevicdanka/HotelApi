
package com.example.guestrecordsapi.repository;
import com.example.guestrecordsapi.dto.GuestResponse;
import com.example.guestrecordsapi.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer > {

    @Query("SELECT new com.example.guestrecordsapi.dto.GuestResponse(g.name, g.surname, h.name, r.date) FROM Reservation r JOIN Hotel h ON h.id=r.hotel JOIN Guest g ON g.guest_id=r.guest")
    List<GuestResponse> getJoinInformation();


}



