package com.example.eventrwportingapplication.Core;

import android.graphics.Bitmap;
import android.location.Location;
import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.RiskLevel;
import com.example.eventrwportingapplication.Enums.Region;
import com.example.eventrwportingapplication.R;

import java.io.Serializable;

public class Event implements Serializable {
//    new i want to use it in db
    private int id;

    //murad asked for:okok
    private EventType eventType;
    private Bitmap Img = null;
    private String description;
    private String location;

    private Region region;
    private RiskLevel riskLevel;
    private String userID;



    //we think we need also :
//    private String eventId;

    //and a counters for 2eshor and d7ia:
//    private boolean isPositiveVoted = false;
//    private boolean isNegativeVoted = false;
//    private int totalNegativeVoted = 0;
//    private int totalPositiveVoted = 0;


    public Event(){
    }
    public Event(String userID,EventType eventType, String location, String description, Region region, RiskLevel riskLevel, Bitmap img) {
        this.eventType = eventType;
        this.location = location;
        this.description = description;
        this.region = region;
        this.riskLevel = riskLevel;
        this.userID = userID;
        Img = img;
    }


    public Event(EventType eventType, String location, String description, Region region, RiskLevel riskLevel, String userId) {
        this.eventType = eventType;
        this.location = location;
        this.description = description;
        this.region = region;
        this.riskLevel = riskLevel;
        this.userID = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
