package com.example.absence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView login,password;
private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        signIn=findViewById(R.id.SignIn);
       signIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(logIn()){
                   Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                   startActivity(intent);

               }else{
                   Toast.makeText(MainActivity.this,"login ou mot de passe incorrecte",Toast.LENGTH_LONG).show();
               }
           }
       });

    }

    public Boolean logIn(){
        if (login.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

            return true;
        }else {
            return false;
        }
    }




}
