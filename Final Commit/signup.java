package com.example.life_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup,signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.conf_pass);
        signin=(Button) findViewById(R.id.sign);
        signup = (Button) findViewById(R.id.lgnbtn);
        DB = new DBHelper(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                {
                    Toast.makeText(signup.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false)
                        {
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(signup.this,"Registred Successfully",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),homescreen.class);
                                startActivity(i);
                            }else {
                                Toast.makeText(signup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signup.this,"User Already exists. PLease Sign In",Toast.LENGTH_SHORT).show();
                        }
                    }else
                        Toast.makeText(signup.this,"Passwords do not match",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}