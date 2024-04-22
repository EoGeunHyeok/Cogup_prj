package org.example.dto;


import java.util.Map;

public class Cul extends Dto {
    public String name;
    public String checkStatus;
    public String checkTime;

    public String member_name;

    public String STATUS;


    public Cul(String name, String checkStatus, String checkTime) {
        this.name = name;
        this.checkStatus = checkStatus;
        this.checkTime = checkTime;
    }

    public Cul(Map<String, Object> row){
        super(row);
        this.name = (String) row.get("name");
        this.checkStatus = (String) row.get("checkStatus");
        this.checkTime = (String) row.get("checkTime");
        this.member_name = (String) row.get("member_name");
        this.STATUS = (String) row.get("STATUS");
    }

}