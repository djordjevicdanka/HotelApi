package com.example.guestrecordsapi.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(Reservation.class)
@Table(name = "Reservation")
public class Reservation implements Serializable {

    @Column(name = "date")
    private String date;

    @JsonManagedReference
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")

    Hotel hotel;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")

    Guest guest;

}
