package com.example.guestrecordsapi.controller;
import com.example.guestrecordsapi.dto.HotelDto;
import com.example.guestrecordsapi.model.Hotel;
import com.example.guestrecordsapi.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;


    @ResponseBody
    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public List<Hotel> getAllHotels(){
        List<Hotel> allHotelList = hotelRepository.findAll();
        return allHotelList;
    }

    @RequestMapping(value = "/hotels",consumes = {"application/json"}, method = RequestMethod.POST)
    public HotelDto addHotel(@RequestBody HotelDto hotelDto) {

        Hotel saveHotel= new Hotel();
        saveHotel.setHotel_id(hotelDto.getHotel_id());
        saveHotel.setAddress(hotelDto.getAddress());
        saveHotel.setEmail(hotelDto.getEmail());
        saveHotel.setName(hotelDto.getName());
        saveHotel.setPhone(hotelDto.getPhone());
        hotelRepository.save(saveHotel);
        return hotelDto;
    }

    @RequestMapping(value = "/hotels/{hotel_id}", method = RequestMethod.DELETE)
    public Hotel deleteHotel(@PathVariable int hotel_id){

        Hotel h= hotelRepository.getOne(hotel_id);

        hotelRepository.delete(h);

        return h;
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.PUT, consumes = {"application/json"})
    public HotelDto updateHotel(@RequestBody HotelDto hotelDto) {

        Hotel saveHotel= new Hotel();
        saveHotel.setHotel_id(hotelDto.getHotel_id());
        saveHotel.setAddress(hotelDto.getAddress());
        saveHotel.setEmail(hotelDto.getEmail());
        saveHotel.setName(hotelDto.getName());
        saveHotel.setPhone(hotelDto.getPhone());
        hotelRepository.save(saveHotel);
        return hotelDto;
    }





}