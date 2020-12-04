package com.example.guestrecordsapi.controller;

import com.example.guestrecordsapi.dto.Response;
import com.example.guestrecordsapi.model.Hotel;
import com.example.guestrecordsapi.repository.HotelRepository;
import com.example.guestrecordsapi.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    //GET
    @ResponseBody
    @RequestMapping(value = "/hotels/GET", method= RequestMethod.GET)
    public List<Hotel> getHotels(){
        return hotelService.getAllHotels();
    }



    @ResponseBody
    @RequestMapping(value = "/hotels/{id}/GET", method = RequestMethod.GET)
    public Hotel getHotelByHotelId(@PathVariable int id){
        return hotelService.getHotel(id);
    }

    //POST -> Save the data
    @ResponseBody
    @RequestMapping(value = "/hotels/POST", method = RequestMethod.POST)
    public void saveHotel(@RequestBody Hotel hotel){
        hotelService.saveHotel(hotel);
    }

    //PUT -> Update the data
    @ResponseBody
    @RequestMapping(value = "/hotels/PUT", method = RequestMethod.PUT)
    public void  updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
    }

    @ResponseBody
    @RequestMapping(value = "/hotels/info/GET", method = RequestMethod.GET)
     List<Response> getJoinInformation(){
        return hotelRepository.getJoinInformation();
    }


    //DELETE -> Delete the data

    public void deleteHotel(int id){
        hotelService.deleteHotel(id);
    }


}
