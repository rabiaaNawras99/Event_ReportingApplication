package com.example.eventrwportingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;


    String[] allowedUsernames = {"user1", "user2", "user3"};

    String correctPassword = "1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //inflate views:
        usernameEditText = findViewById(R.id.editTextTextPersonName);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if (isValidLogin(username, password)) {
                Intent intent = new Intent(LoginActivity.this, AddEventActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });


    }


    private boolean isValidLogin(String username, String password) {
        for (String allowedUsername : allowedUsernames) {
            if (username.equals(allowedUsername) && password.equals(correctPassword)) {
                return true;
            }
        }
        return false;
    }
}