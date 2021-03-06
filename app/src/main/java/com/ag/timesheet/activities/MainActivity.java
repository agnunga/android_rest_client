package com.ag.timesheet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ag.timesheet.R;

import com.ag.timesheet.helper.SharedPrefManager;
import com.ag.timesheet.services.PhotoService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if user is already logged in openeing the profile activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeActivity.class));
        }

        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);

        startService(new Intent(MainActivity.this, PhotoService.class));

    }

    @Override
    public void onClick(View view) {

        if (view == buttonSignIn) {

            startActivity(new Intent(this, SignInActivity.class));

        } else if (view == buttonSignUp) {

            startActivity(new Intent(this, SignUpActivity.class));

        }
    }
}
