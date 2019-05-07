package com.cam.mylistas;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {
    private  List<Persona>personaList = new ArrayList<>();
    private RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);


        personaList.add(new Persona("Oton","01/03/1986",
                "Masculino","Profesor del departamento en la clase de android"));
        personaList.add(new Persona("Maria","08/07/1996",
                "Femenino","Encargada de Caja"));
        personaList.add(new Persona("Rebeca","12/08/1989",
                "Femenino","Jefa de seccion"));
        personaList.add(new Persona("Roberto","18/04/2018",
                "Masculino","Bebe internado"));

        RecyclerView rvPersona = findViewById(R.id.rvPersonas);
        RvAdapter.OnItemClickListener onItemClickListener = new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(RVActivity.this,
                        personaList.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        };
        rvAdapter= new RvAdapter(personaList, onItemClickListener);
       // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rvPersona.setHasFixedSize(true);
        rvPersona.setLayoutManager(layoutManager);
        rvPersona.setAdapter(rvAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,FormPersonaActivity.class);
        startActivityForResult(intent,2544);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2544)
        {
            if (resultCode==RESULT_OK)
            {
                Bundle bundle= data.getExtras();
                Persona persona= (Persona) bundle.get("persona");
                personaList.add(persona);
                rvAdapter.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}





