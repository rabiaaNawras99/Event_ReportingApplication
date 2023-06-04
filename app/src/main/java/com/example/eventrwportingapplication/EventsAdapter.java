package com.example.eventrwportingapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eventrwportingapplication.Core.Event;
import com.example.eventrwportingapplication.Enums.FragmentName;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Event> listEvents;
    private FragmentName fragment;
    private onEditClickListener listener;

    /**
     * Initialize the dataset of the Adapter.
     */

    public EventsAdapter(List<Event> listEvents, FragmentName fragment, onEditClickListener listener) {
        this.listEvents = listEvents;
        this.fragment = fragment;
        this.listener = listener;
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

    public interface onEditClickListener {
        void editEvent(Event event);
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvEventTyp;
        private TextView tvLocation;
        private TextView tvDescription;
        private TextView tvRegion;
        private TextView tvRiskLevel;
        private ImageView ImageViewEvent;
        private Button deleteBtn;
        private Button editBtn;

        private Event event;


        public ViewHolder(View itemView) {
            super(itemView);

            tvEventTyp = itemView.findViewById(R.id.input_text_view_event_type);
            tvLocation = itemView.findViewById(R.id.input_text_view_event_location);
            tvDescription = itemView.findViewById(R.id.input_text_view_event_description);
            tvRegion = itemView.findViewById(R.id.input_text_view_event_region);
            tvRiskLevel = itemView.findViewById(R.id.input_text_view_event_risk_level);
            ImageViewEvent = itemView.findViewById(R.id.image_view_event);
            deleteBtn = itemView.findViewById(R.id.delete_button);
            editBtn = itemView.findViewById(R.id.edit_button);


            //Do not display buttons delete and update in home Fragment
            if (fragment == FragmentName.MyProfile) {

                deleteBtn.setVisibility(View.VISIBLE);
                editBtn.setVisibility(View.VISIBLE);

            } else if (fragment == FragmentName.Home) {

                deleteBtn.setVisibility(View.GONE);
                editBtn.setVisibility(View.GONE);
            }
        }

        public void setData(Event event) {
            this.event = event;
            tvEventTyp.setText(event.getEventType().toString());
            tvLocation.setText(event.getLocation());
            tvDescription.setText(event.getDescription());
            tvRegion.setText(event.getRegion().toString());
            tvRiskLevel.setText(event.getRiskLevel().toString());


            if (fragment == FragmentName.MyProfile) {
                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.editEvent(event);
                    }
                });

                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // 1. Instantiate an AlertDialog.Builder with its constructor
                        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());

                        // 2. Chain together various setter methods to set the dialog characteristics
                        builder.setMessage("Are you sure?");
                        builder.setTitle("Delete");

                        // Add the buttons
                        //PositiveButton
                        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(itemView.getContext(), "User clicked OK button", Toast.LENGTH_SHORT).show();
                            }
                        });

                        //NegativeButton
                        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(itemView.getContext(), "User cancelled the dialog", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.show();
                    }
                });
            }
        }
    }
}




