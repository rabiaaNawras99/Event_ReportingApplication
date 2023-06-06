package com.example.eventrwportingapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.eventrwportingapplication.Core.Event;
import com.example.eventrwportingapplication.Core.User;

import java.util.ArrayList;
import java.util.List;

/*
controller
 */
public class EventManager {
    private static EventManager instance = null;
//
    private EventDatabase db = null;

    private Context context = null;

    private Event selectedEvent = null;
    private User selectedUser = null;


    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //today
    private Bitmap takenPostPicture = null;

    public Bitmap getTakenPostPicture() {
        return takenPostPicture;
    }

    public void setTakenPostPicture(Bitmap takenPostPicture) {
        this.takenPostPicture = takenPostPicture;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
    //Singleton
    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    public void openDataBase(Context context) {
        this.context = context;
        if (context != null) {
            db = new EventDatabase(context);
            db.open();
        }
    }

    public void closeDataBase() {
        if (db != null) {
            db.close();
        }
    }

    public void createEvent(Event event) {
        if (db != null) {

            db.createEvent(getSelectedUser(), event);
        }
    }

    public List<Event> getAllEvents() {
        List<Event> result = new ArrayList<>();
        if (db != null) {
            result = db.getAllEvents();
        }
        return result;
    }

    public List<Event> getUserEvents(User user) {
        List<Event> result = new ArrayList<Event>();
        if (db != null && user != null) {
            result = db.getAllEventsOfUser(user);
        }
        return result;

    }
    public void updateEvent(Event event) {
        if (db != null && event != null) {
            db.updateEvent(event);
        }
    }

    public void deleteEvent(Event event) {
        if (db != null) {
            db.deleteEvent(event);
        }
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }


}
