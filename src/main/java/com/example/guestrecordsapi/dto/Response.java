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
    private String name;
    private String email;
    private int guest_id;
    private String guest_name;
    private String surname;
    private String phone;

}
