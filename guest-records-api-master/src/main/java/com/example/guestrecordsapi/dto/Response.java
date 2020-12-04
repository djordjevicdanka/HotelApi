package com.example.guestrecordsapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Response {

    @Id
    private int hotelId;
    private String hotelName;
    private String hotelPhone;
    private String hotelAddress;
    private String hotelEmail;
    private String guestName;
    private String guestSurname;
    private String guestPhone;
    private String guestReservation;

}
