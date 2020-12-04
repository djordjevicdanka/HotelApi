package com.example.guestrecordsapi.controller;
import com.example.guestrecordsapi.dto.GuestResponse;
import com.example.guestrecordsapi.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @ResponseBody
    @RequestMapping(value = "/guests/GET",method = RequestMethod.GET)
    public List<GuestResponse> getAllGuests() {
        return guestRepository.findAllGuests();
    }


    @RequestMapping(value = "/guests/{guest_id}/GET", method = RequestMethod.GET)
    public List<GuestResponse> getGuestById() {
        return guestRepository.findGuestById();
    }



}