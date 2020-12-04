package com.example.guestrecordsapi.repository;
import com.example.guestrecordsapi.dto.Response;
import com.example.guestrecordsapi.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("SELECT new com.example.guestrecordsapi.dto.Response(h.id, h.name, h.phone, h.address, h.email, g.name, g.surname, g.phone, r.date) FROM Reservation r JOIN Hotel h ON h.id=r.hotel JOIN Guest g ON g.guest_id=r.guest ")

    List<Response> getJoinInformation();
}
