package com.cam.mylistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        List<Persona>personaList = new ArrayList<>();
        personaList.add(new Persona("Oton","01/03/1986",
                "Masculino","Profesor del departamento en la clase de android"));
        personaList.add(new Persona("Maria","08/07/1996",
                "Femenino","Encargada de Caja"));
        personaList.add(new Persona("Rebeca","12/08/1989",
                "Femenino","Jefa de seccion"));
        personaList.add(new Persona("Roberto","18/04/2018",
                "Masculino","Bebe internado"));

        RecyclerView rvPersona = findViewById(R.id.rvPersonas);
        RvAdapter rvAdapter= new RvAdapter(personaList);
       // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rvPersona.setHasFixedSize(true);
        rvPersona.setLayoutManager(layoutManager);
        rvPersona.setAdapter(rvAdapter);
    }
}
