package com.example.eventrwportingapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventrwportingapplication.Core.Event;
import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.FragmentName;
import com.example.eventrwportingapplication.Enums.Region;
import com.example.eventrwportingapplication.Enums.RiskLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment implements EventsAdapter.onEditClickListener {

    private RecyclerView recyclerView;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        recyclerView = view.findViewById(R.id.my_profile_events_recyclerview);
        initializeData();
        return view;
    }

    private void initializeData() {
        List<Event> list = getEventsDemo();
        if (list != null && list.size() > 0) {
            EventsAdapter adapter = new EventsAdapter(list, FragmentName.MyProfile, this);
            LinearLayoutManager ll = new LinearLayoutManager(getActivity());
            ll.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(ll);
            recyclerView.setAdapter(adapter);
        }
    }

    public List<Event> getEventsDemo() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("user1", EventType.health, "qq1", "ss1", Region.Haifa_District, RiskLevel.easy, null));
        events.add(new Event("user2", EventType.health, "qq2", "ss2", Region.Haifa_District, RiskLevel.easy, null));
        events.add(new Event("user1", EventType.health, "qq3", "s3s", Region.Haifa_District, RiskLevel.easy, null));

        events.add(new Event("user2", EventType.health, "qq4", "ss4", Region.Haifa_District, RiskLevel.easy, null));
        events.add(new Event("user1", EventType.environmental, "dddqq", "sdds", Region.Central_District, RiskLevel.easy, null));

        List<Event> filteredEvents = new ArrayList<>();
        for (Event e : events) {
            if (e.getUserID() == "user1") {
                filteredEvents.add(e);
            }
        }
        return filteredEvents;
    }

    @Override
    public void editEvent(Event event) {
        EditFragment editFragment = new EditFragment();
        FragmentManager fm = getFragmentManager();

        Bundle args = new Bundle();
        args.putSerializable("event", event);
        editFragment.setArguments(args);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.root_view, editFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}