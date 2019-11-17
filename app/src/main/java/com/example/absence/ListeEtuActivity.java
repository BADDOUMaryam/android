package com.example.absence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Model.Etudiant;

public class ListeEtuActivity extends AppCompatActivity {

    private ListView all;
    ArrayList<Etudiant> etudiants = Etudiant.getEtudiants();
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etu);
        all = findViewById(R.id.all);
        save = findViewById(R.id.save);
        adapter();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
                present();
            }
        });

    }

    public void present() {


        SparseBooleanArray checkedItemPositions = all.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                Etudiant item = (Etudiant) all.getAdapter().getItem(checkedItemPositions.keyAt(i));
                Etudiant e = Etudiant.getEtudiants().get(Etudiant.getEtudiants().indexOf(item));
                e.setPresent(true);

            }
            Intent intent=new Intent(ListeEtuActivity.this,HomeActivity.class);
            startActivity(intent);


        }
    }
    public void isPresent(){
        for(int i = 0;i<Etudiant.getEtudiants().size();i++){
            Etudiant e = Etudiant.getEtudiants().get(i);
            if(e.getPresent()) all.setItemChecked(i,true);
        }
    }
    public void adapter(){
        ArrayList<Etudiant> etudiantsS = new ArrayList<>();
        for (Etudiant e : etudiants) {
            etudiantsS.add(e);
        }
        ArrayAdapter<Etudiant> adapter = new ArrayAdapter<Etudiant>(this, android.R.layout.simple_list_item_multiple_choice, etudiantsS);
        all.setAdapter(adapter);
        all.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        isPresent();
    }
    public void init() {
        for (Etudiant e : Etudiant.getEtudiants()) {
            e.setPresent(false);
        }
    }
}
