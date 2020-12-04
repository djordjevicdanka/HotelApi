
package com.example.guestrecordsapi.service;
import com.example.guestrecordsapi.model.Guest;
import com.example.guestrecordsapi.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService{

    @Autowired
    private GuestRepository guestRepository;

    private List<Guest> list= new ArrayList<>();


    //Return AllGuests
    public List<Guest> getAllGuests() {
        List<Guest> guestList = new ArrayList<>();
        guestRepository.findAll().forEach(guestList::add);
        return guestList;
    }

    //Return Single Guest
    public Guest getGuest(int guest_id){
        Optional<Guest> optionalGuest = guestRepository.findById(guest_id);
        if(optionalGuest.isPresent()){
            return optionalGuest.get();
        }
        return null;
    }

    //Save the guest
    public void saveGuest(Guest guest){
        guestRepository.save(guest);
    }

    //Update the guest
    public void updateGuest(Guest guest){
        guestRepository.save(guest);
    }

    //Remove the guest
    public void deleteGuest(int guest_id){
        guestRepository.deleteById(guest_id);
    }
}


