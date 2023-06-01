package com.example.eventrwportingapplication.Core;

import android.graphics.Bitmap;

import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.RiskLevel;
import com.example.eventrwportingapplication.Enums.Region;

public class Event {
    //murad asked for:okok
    private EventType eventType;
    private Bitmap Img = null;
    private String eventDescription;
    private String eventAddress;
    private Region eventRegion;
    private RiskLevel riskLevel;


    //we think we need also :
    private String eventId;

    //and a counters for 2eshor and d7ia:
    private boolean isPositiveVoted = false;
    private boolean isNegativeVoted = false;
    private int totalNegativeVoted = 0;
    private int totalPositiveVoted = 0;


}
