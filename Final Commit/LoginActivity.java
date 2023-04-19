package com.example.life_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, passwords;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.loginuser);
        passwords = (EditText) findViewById(R.id.loginpass);
        btnlogin = (Button) findViewById(R.id.lgnbtn);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = passwords.getText().toString();

                if(user.equals("")||pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);

                    if(checkuserpass==true)
                    {
                        Toast.makeText(LoginActivity.this, "Signed In", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),homescreen.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            };
        });
    }}
