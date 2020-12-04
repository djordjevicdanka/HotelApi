package com.example.guestrecordsapi.service;
import com.example.guestrecordsapi.model.Hotel;
import com.example.guestrecordsapi.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    private List <Hotel> list= new ArrayList<>();


    //Return AllHotels
    public List<Hotel> getAllHotels() {
        List<Hotel> hotelList = new ArrayList<>();
        hotelRepository.findAll().forEach(hotelList::add);
        return hotelList;
    }

    //Return Single Hotel
    public Hotel getHotel(int id){
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if(optionalHotel.isPresent()){
            return optionalHotel.get();
        }
        return null;
    }

    //Save the hotel
    public void saveHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }

    //Update the hotel
    public void updateHotel(Hotel hotel){
      hotelRepository.save(hotel);
    }

    //Remove the hotel
    public void deleteHotel(int id){
        hotelRepository.deleteById(id);
    }


}

