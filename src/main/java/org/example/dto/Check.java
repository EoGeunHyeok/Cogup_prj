package org.example.dto;

import lombok.Getter;

@Getter
public class Check {
    public String name;
    public String reservation;
    public String time;
    public String checkPw;


    public Check (String name, String reservation, String time, String checkPw) {
        this.name = name;
        this.reservation = reservation;
        this.time = time;
        this.checkPw = checkPw;
    }
}
