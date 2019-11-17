package com.example.absence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import Model.Etudiant;

public class HomeActivity extends AppCompatActivity {
private Button addEtudiant,listeEtudiants;
private ArrayList<Etudiant> etudiants=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addEtudiant=findViewById(R.id.etudiant);
        listeEtudiants=findViewById(R.id.liste);
        addEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,AddEtuActivity.class);
                //intent.putExtra("Liste",etudiants);
                startActivity(intent);
            }
        });
        listeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,ListeEtuActivity.class);
                startActivity(intent);
            }
        });
    }
}
