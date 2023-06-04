package com.example.eventrwportingapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.eventrwportingapplication.Core.Event;

public class EditFragment extends Fragment{

    private EditText etEventTyp;
    private EditText etLocation;
    private EditText etDescription;
    private EditText etRegion;
    private EditText etRiskLevel;

    private ImageView ImageViewEvent;

    public EditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        Bundle args = getArguments();
        Event event = (Event)args.getSerializable("event");


         etEventTyp    = view.findViewById(R.id.edit_text_event_type);
         etLocation    = view.findViewById(R.id.edit_text_event_location);
         etDescription = view.findViewById(R.id.edit_text_event_description);
         etRegion      = view.findViewById(R.id.edit_text_event_region);
         etRiskLevel   = view.findViewById(R.id.edit_text_event_risk_level);
         ImageViewEvent = view.findViewById(R.id.edit_image_view_event);
         editEvent(event);
        return view;
    }

    public void editEvent(Event event){
        etEventTyp.setText(event.getEventType().toString());
        etLocation.setText(event.getLocation());
        etDescription.setText(event.getDescription());
        etRegion.setText(event.getRegion().toString());
        etRiskLevel.setText(event.getRiskLevel().toString());

    }
}