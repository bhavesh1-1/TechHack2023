package com.example.life_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class simon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        Button b1 = (Button) findViewById(R.id.start);
        TextView tv = (TextView) findViewById(R.id.command);
        tv.setText("Use your eyes for these exercises");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int min = 1;
                    int max = 10;
                    int res = (int) (Math.random() * (max - min + 1) + min);
                    if (res==1) {
                        tv.setText("Look left");

                    } else if (res==2) {
                        tv.setText("Look Right");
                    } else if (res==3) {
                        tv.setText("Look Up");
                    } else if (res==4) {
                        tv.setText("Look Down");
                    } else if (res==5) {
                        tv.setText("Upper Right Side");
                    } else if (res > 5 && res < 7) {
                        tv.setText("Upper Left side");
                    } else if (res==8) {
                        tv.setText("Bottom Left Side");
                    } else if (res > 8 && res< 11) {
                        tv.setText("Bottom Right Side");
                    }

                }
        });
    }
}