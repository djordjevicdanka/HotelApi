
package com.example.guestrecordsapi.service;
import com.example.guestrecordsapi.model.Guest;
import com.example.guestrecordsapi.model.Reservation;
import com.example.guestrecordsapi.repository.GuestRepository;
import com.example.guestrecordsapi.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    private List<Reservation> list= new ArrayList<>();


    //Return AllReservations
    public List<Reservation> getAllReservations() {
        List<Reservation> reservationList = new ArrayList<>();
        reservationRepository.findAll().forEach(reservationList::add);
        return reservationList;
    }

    //Return Single Reservation
    public Reservation getReservation(int guest_id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(guest_id);
        if(optionalReservation.isPresent()){
            return optionalReservation.get();
        }
        return null;
    }

    //Save the reservation
    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    //Update the reservation
    public void updateReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    //Remove the reservation
    public void deleteReservation(int guest_id){
        reservationRepository.deleteById(guest_id);
    }
}


