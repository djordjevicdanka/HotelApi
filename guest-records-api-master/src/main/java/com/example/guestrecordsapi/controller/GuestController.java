
package com.example.guestrecordsapi.controller;
import com.example.guestrecordsapi.dto.GuestResponse;
import com.example.guestrecordsapi.model.Guest;
import com.example.guestrecordsapi.repository.GuestRepository;
import com.example.guestrecordsapi.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestRepository guestRepository;

    //GET
    @ResponseBody
    @RequestMapping(value = "/guests/GET", method= RequestMethod.GET)
    public List<Guest> getGuests(){
        return guestService.getAllGuests();
    }

    @ResponseBody
    @RequestMapping(value = "/guests/{guest_id}/GET", method = RequestMethod.GET)
    public Guest getGuestByGuestId(@PathVariable int guest_id){
        return guestService.getGuest(guest_id);
    }

    //POST -> Save the data
    @ResponseBody
    @RequestMapping(value = "/guests/POST", method = RequestMethod.POST)
    public void saveGuest(@RequestBody Guest guest){
        guestService.saveGuest(guest);
    }

    //PUT -> Update the data
    @ResponseBody
    @RequestMapping(value = "/guests/PUT", method = RequestMethod.PUT)
    public void  updateGuest(@RequestBody Guest guest){
        guestService.updateGuest(guest);
    }

    @ResponseBody
    @RequestMapping(value = "/guests/info/GET", method = RequestMethod.GET)
    List<GuestResponse> getJoinInformation(){
        return guestRepository.getJoinInformation();
    }


    //DELETE -> Delete the data
    public void deleteGuest(int guest_id ){
        guestService.deleteGuest(guest_id);
    }

}

