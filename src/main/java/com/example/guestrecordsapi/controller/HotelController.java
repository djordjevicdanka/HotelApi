package com.example.guestrecordsapi.controller;
import com.example.guestrecordsapi.model.Hotel;
import com.example.guestrecordsapi.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HotelController extends Hotel {

    @Autowired
    HotelRepository hotelRepository;


    @ResponseBody
    @RequestMapping(value = "/hotels/GET", method = RequestMethod.GET)
    public List<Hotel> getAllHotels(){
        List<Hotel> allHotelList = hotelRepository.findAll();
        return allHotelList;
    }

    @RequestMapping(value = "/hotels/add",consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public Hotel addHotel(@RequestBody Hotel hotel) {
        Hotel saveHotel=hotelRepository.save(hotel);
        return saveHotel;
    }



    @RequestMapping(value = "/hotels/DELETE", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteStudents(@RequestParam(value = "hotel_id") int hotel_id)
    {
        Hotel hotel = hotelRepository.findById(hotel_id).get();

        hotelRepository.delete(hotel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}