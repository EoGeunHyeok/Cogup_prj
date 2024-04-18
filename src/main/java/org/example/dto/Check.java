package org.example.dto;

import lombok.Getter;

@Getter
public class Check {
    public String name;
    public String reservation;
    public String time;


    public Check (String name, String reservation, String time) {
        this.name = name;
        this.reservation = reservation;
        this.time = time;
    }
}
