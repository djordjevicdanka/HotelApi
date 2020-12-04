package com.example.guestrecordsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class GuestResponse implements Serializable {

    String hotelName;
    @Id
    int guest_id;
    String name;
    String surname;
    String phone;

}
