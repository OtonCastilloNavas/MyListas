package com.cam.mylistas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final List<String> nombre = new ArrayList<>();
    ArrayAdapter<String> adapter;
    List<Persona> personaList = new ArrayList<>();
    MiAdapterPersona adapterPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvLista= findViewById(R.id.lvLista);

//        nombre.add("Marlon");
//        nombre.add("Joaquin");
//        nombre.add("Katherine");
//        nombre.add("Anabell");
//        nombre.add("Emilio");
//        nombre.add("Keyling");
//        nombre.add("Oton");
//        nombre.add("Erick");
//        nombre.add("Ney");
//        nombre.add("Pablo");
//        nombre.add("Elena");
//        nombre.add("Javier");
//        nombre.add("Esteban");
//        nombre.add("sophia");
//        nombre.add("Carlota");
//        nombre.add("Juan");
//        adapter=
//                new ArrayAdapter<String>(this,
//                        android.R.layout.simple_list_item_1,
//                        nombre);
//        lvLista.setAdapter(adapter);
//
//        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//                //Toast.makeText(MainActivity.this, nombre.get(position), Toast.LENGTH_SHORT).show();
//                TextView tvClick=(TextView)view;
//                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Borrar");
//                builder.setMessage("Desea borrar?");
//                builder.setNegativeButton("No", null);
//                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        nombre.remove(position);
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//                //Toast.makeText(MainActivity.this, tvClick.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        Persona persona= new Persona();
//        persona.setNombre();
//        persona= new Persona("","","","");
        personaList.add(new Persona("Oton","01/03/1986",
                "Masculino","Profesor del departamento en la clase de android"));
        personaList.add(new Persona("Maria","08/07/1996",
                "Femenino","Encargada de Caja"));
        personaList.add(new Persona("Rebeca","12/08/1989",
                "Femenino","Jefa de seccion"));
        personaList.add(new Persona("Roberto","18/04/2018",
                "Masculino","Bebe internado"));

        adapterPersona = new MiAdapterPersona(this,
                R.layout.item_persona,personaList);

        lvLista.setAdapter(adapterPersona);
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvNombre=view.findViewById(R.id.tvNombre);
                TextView tvFechaNac=view.findViewById(R.id.tvFechaNac);
                Toast.makeText(MainActivity.this,tvNombre.getText().toString() +
                        " " + tvFechaNac.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View view)
    {
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etSexo = findViewById(R.id.etSexo);
        EditText etFechaNac = findViewById(R.id.etFechNac);
        EditText etDescripcion = findViewById(R.id.etDescripcion);
        personaList.add(new Persona(etNombre.getText().toString(),
                etFechaNac.getText().toString(),
                etSexo.getText().toString(),
                etDescripcion.getText().toString()));
        adapterPersona.notifyDataSetChanged();

//        nombre.add(etNombre.getText().toString());
//        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
    }

}
