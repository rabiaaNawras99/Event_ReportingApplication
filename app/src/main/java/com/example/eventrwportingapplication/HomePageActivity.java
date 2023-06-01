package com.example.eventrwportingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.eventrwportingapplication.Core.Event;
import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.Region;
import com.example.eventrwportingapplication.Enums.RiskLevel;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private EventsAdapter adapter;
    private List<Event> events;


    public List<Event> getEventsDemo() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(EventType.health, "qq", "ss", Region.Haifa_District, RiskLevel.easy, null));
        events.add(new Event(EventType.environmental, "dddqq", "sdds", Region.Central_District, RiskLevel.easy, null));
        return events;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RecyclerView recList = findViewById(R.id.event_card_recyclerview);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recList.setLayoutManager(llm);
        events = getEventsDemo();
        adapter = new EventsAdapter(events);
        recList.setAdapter(adapter);
    }


}