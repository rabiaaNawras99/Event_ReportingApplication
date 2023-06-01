package com.example.eventrwportingapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eventrwportingapplication.Core.Event;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Event> listEvents;

    /**
     * Initialize the dataset of the Adapter.
     */

    public EventsAdapter(List<Event> listEvents) {
        this.listEvents = listEvents;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.event_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = listEvents.get(position);
        holder.setData(event);
    }

    @Override
    public int getItemCount() {
        return listEvents.size();
    }

    public void addEvent(Event event) {
        listEvents.add(event);
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView TVEventTyp;
        private TextView TVLocation;
        private TextView TVDescription;
        private TextView TVRegion;
        private TextView TVRiskLevel;
        private ImageView ImageViewEvent;

        private Event event;


        public ViewHolder(View itemView) {
            super(itemView);

            TVEventTyp = itemView.findViewById(R.id.input_text_view_event_type);
            TVLocation = itemView.findViewById(R.id.input_text_view_event_location);
            TVDescription = itemView.findViewById(R.id.input_text_view_event_description);
            TVRegion = itemView.findViewById(R.id.input_text_view_event_region);
            TVRiskLevel = itemView.findViewById(R.id.input_text_view_event_risk_level);
            ImageViewEvent = itemView.findViewById(R.id.input_image_view_event);
        }

        public void setData(Event event) {

            TVEventTyp.setText(event.getEventType().toString());
            TVLocation.setText(event.getLocation());
            TVDescription.setText(event.getDescription());
            TVRegion.setText(event.getRegion().toString());
            TVRiskLevel.setText(event.getRiskLevel().toString());
//            TVImage


        }


    }
}



