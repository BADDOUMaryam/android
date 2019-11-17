package com.example.absence;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import Model.Etudiant;

public class AddEtuActivity extends AppCompatActivity {
private ArrayList<Etudiant> etudiants=new ArrayList<>();
private TextView nom,prenom,cne;
private Button ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etu);
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        cne=findViewById(R.id.cne);
        ajouter=findViewById(R.id.add);
      
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter(nom.getText().toString(),prenom.getText().toString(),cne.getText().toString());
                Toast.makeText(AddEtuActivity.this,"Etudiant bien Ajouté",Toast.LENGTH_LONG).show();

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                init();
            }
        });

    }
    public void ajouter(String nom,String prenom,String cne){
        Etudiant etu=new Etudiant(nom,prenom,cne);
        //etudiants.add(etu);
        Etudiant.getEtudiants().add(etu);
    }
    public void init(){
       nom.setText("");
       prenom.setText("");
       cne.setText("");

    }
}
