package com.example.eventrwportingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.eventrwportingapplication.Core.Event;


import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private ImageButton imagButtonHome;
    private Button myProfileBtn;
    private EventsAdapter adapter;
    private List<Event> events;
    private FragmentManager fragmentManager;
    private String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //
        EventManager.getInstance().openDataBase(this);



        // set current user
        Intent intent = getIntent();
        currentUser = intent.getStringExtra("username");
        // DB.setUser(currentuser)
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        ft.replace(R.id.root_view, homeFragment);
        ft.addToBackStack(null);
        ft.commit();

        myProfileBtn = findViewById(R.id.my_profile_btn);
        myProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                MyProfileFragment profileFragment = new MyProfileFragment();
                ft.replace(R.id.root_view, profileFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imagButtonHome = findViewById(R.id.home_btn);
        imagButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                ft.replace(R.id.root_view, homeFragment);
                ft.addToBackStack(null);
                ft.commit();


            }
        });
    }





//    public <T extends Fragment> void  updateFragment(T fragment){
//        fragmentManager = getFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        //HomeFragment homeFragment = new HomeFragment();
//        ft.replace(R.id.root_view, fragment);
//        ft.addToBackStack(null);
//        ft.commit();
//    }
}