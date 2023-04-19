package com.example.life_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class homescreen extends AppCompatActivity {
Button chronic,mental,simonsays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        mental = (Button) findViewById(R.id.mental);
        simonsays = (Button) findViewById(R.id.simonsays);
        simonsays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),simon.class);
                startActivity(i);
            }
        });
        mental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MentAI.class);
                startActivity(i);
            }
        });
    }
}