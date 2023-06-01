package com.example.eventrwportingapplication.Core;

import android.graphics.Bitmap;
import android.location.Location;

import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.RiskLevel;
import com.example.eventrwportingapplication.Enums.Region;
import com.example.eventrwportingapplication.R;

public class Event {
    //murad asked for:okok
    private EventType eventType;
    private String location;
    private String description;
    private Region region;
    private RiskLevel riskLevel;
    private Bitmap Img = null;



    //we think we need also :
//    private String eventId;

    //and a counters for 2eshor and d7ia:
//    private boolean isPositiveVoted = false;
//    private boolean isNegativeVoted = false;
//    private int totalNegativeVoted = 0;
//    private int totalPositiveVoted = 0;


    public Event(EventType eventType, String location, String description, Region region, RiskLevel riskLevel, Bitmap img) {
        this.eventType = eventType;
        this.location = location;
        this.description = description;
        this.region = region;
        this.riskLevel = riskLevel;
        Img = img;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Bitmap getImg() {
        return Img;
    }

    public void setImg(Bitmap img) {
        Img = img;
    }
//
//    public String getEventId() {
//        return eventId;
//    }
//
//    public void setEventId(String eventId) {
//        this.eventId = eventId;
//    }
//
//    public boolean isPositiveVoted() {
//        return isPositiveVoted;
//    }
//
//    public void setPositiveVoted(boolean positiveVoted) {
//        isPositiveVoted = positiveVoted;
//    }
//
//    public boolean isNegativeVoted() {
//        return isNegativeVoted;
//    }
//
//    public void setNegativeVoted(boolean negativeVoted) {
//        isNegativeVoted = negativeVoted;
//    }
//
//    public int getTotalNegativeVoted() {
//        return totalNegativeVoted;
//    }
//
//    public void setTotalNegativeVoted(int totalNegativeVoted) {
//        this.totalNegativeVoted = totalNegativeVoted;
//    }
//
//    public int getTotalPositiveVoted() {
//        return totalPositiveVoted;
//    }
//
//    public void setTotalPositiveVoted(int totalPositiveVoted) {
//        this.totalPositiveVoted = totalPositiveVoted;
//    }
}
