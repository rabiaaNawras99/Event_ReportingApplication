package com.example.eventrwportingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eventrwportingapplication.Core.Event;
import com.example.eventrwportingapplication.Core.User;
import com.example.eventrwportingapplication.Enums.EventType;
import com.example.eventrwportingapplication.Enums.Region;
import com.example.eventrwportingapplication.Enums.RiskLevel;

public class AddEventActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 11;

    private Spinner selectedEventType;
    private EditText eventLocationView;
    private EditText eventDescriptionView;
    private Spinner selectedRegion;
    private Spinner selectedRiskLevel;
    private ImageView eventImageView;

    private Button addEvent = null;
    private Button deleteEvent;
    private Button takePhotoOfEvent;


    private Activity context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_event);

        //
        EventManager.getInstance().openDataBase(this);


//        dispatchTakePictureIntent();

        selectedEventType = findViewById(R.id.spinnerInputEventType);
        eventLocationView = findViewById(R.id.add_editText_event_location);
        eventDescriptionView = findViewById(R.id.add_editText_event_description);
        selectedRegion = findViewById(R.id.spinnerInput_eventRegion);
        selectedRiskLevel = findViewById(R.id.spinnerInput_event_risk_level);
        eventImageView = findViewById(R.id.add_image_view_to_event);


        //buttons
        deleteEvent = findViewById(R.id.delete_event_button);
        takePhotoOfEvent = findViewById(R.id.add_photo_button);
        addEvent = findViewById(R.id.add_event_button);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    EventType eventType = EventType.valueOf((String) selectedEventType.getSelectedItem().toString());
                    String location = eventLocationView.getText().toString();
                    String description = eventDescriptionView.getText().toString();
                    Region region = Region.valueOf((String) selectedRegion.getSelectedItem().toString());
                    RiskLevel riskLevel = RiskLevel.valueOf((String) selectedRiskLevel.getSelectedItem().toString());
                    String userId = EventManager.getInstance().getSelectedUser().getUsername();


                    Event event = EventManager.getInstance().getSelectedEvent();
                    if (event == null) {
                        event = new Event(eventType, location, description, region, riskLevel, userId);

                        EventManager.getInstance().createEvent(event);
                    }
//                    else {
//                        event.setLocation(location);
//                        event.setDescription(description);
//                        if (event.getId() == NEW_EVENT_TAG) {
//                            EventManager.getInstance().createEvent(event);
//                        }
//                    }
                    Intent intent =new Intent(AddEventActivity.this,HomePageActivity.class);
                    startActivity(intent);

                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });


//        takePhotoOfEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
//                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//                }
//
//            }
//        });
//    }


//    :(((!!! Does not work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            eventImageView.setImageBitmap(imageBitmap);
//        }
    }
//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            if (imageBitmap != null) {
//                Bitmap scaledImageBitmap = getScaledImage(imageBitmap);
//                EventManager.getInstance().setTakenPostPicture(scaledImageBitmap);
//            }
//            finish();
//        }
//    }
//
//    private Bitmap getScaledImage(Bitmap imageBitmap) {
//        // Get the dimensions of the View
//        Bitmap scaledBitmap = null;
//        try {
//
//            Matrix matrix = new Matrix();
//            matrix.postRotate(90);
//
//            Bitmap rotatedBitmap =  Bitmap.createScaledBitmap(imageBitmap, PHOTO_W, PHOTO_H, false);
//            scaledBitmap = Bitmap.createBitmap(rotatedBitmap , 0, 0, rotatedBitmap.getWidth(), rotatedBitmap.getHeight(), matrix, true);
//
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return scaledBitmap;
//    }


}