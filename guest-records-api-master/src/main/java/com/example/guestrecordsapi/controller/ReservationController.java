
package com.example.guestrecordsapi.controller;
import com.example.guestrecordsapi.model.Reservation;
import com.example.guestrecordsapi.repository.ReservationRepository;
import com.example.guestrecordsapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    //GET
    @ResponseBody
    @RequestMapping(value = "/reservations/GET", method= RequestMethod.GET)
    public List<Reservation> getReservations(){
        return reservationService.getAllReservations();
    }

    @ResponseBody
    @RequestMapping(value = "/reservations/{guest_id}/GET", method = RequestMethod.GET)
    public Reservation getReservationByGuestId(@PathVariable int guest_id){
        return reservationService.getReservation(guest_id);
    }

    //POST -> Save the data
    @ResponseBody
    @RequestMapping(value = "/reservations/POST", method = RequestMethod.POST)
    public void saveGReservation(@RequestBody Reservation reservation){
        reservationService.saveReservation(reservation);
    }

    //PUT -> Update the data
    @ResponseBody
    @RequestMapping(value = "/reservations/PUT", method = RequestMethod.PUT)
    public void  updateReservation(@RequestBody Reservation reservation){
        reservationService.updateReservation(reservation);
    }



    //DELETE -> Delete the data
    public void deleteReservation(int guest_id ){
        reservationService.deleteReservation(guest_id);
    }

}
