package com.cam.mylistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormPersonaActivity extends AppCompatActivity {

    private Persona persona= new Persona();
    private EditText etNombre;
    private EditText etFechaNac;
    private EditText etSexo;
    private EditText etDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_persona);
        etNombre= findViewById(R.id.etNombre);
        etFechaNac= findViewById(R.id.etFechNac);
        etSexo= findViewById(R.id.etSexo);
        etDescripcion= findViewById(R.id.etDescripcion);
    }

    public void onClick(View view)
    {
        persona.setNombre(etNombre.getText().toString());
        persona.setDescripcion(etDescripcion.getText().toString());
        persona.setFechaNacimiento(etFechaNac.getText().toString());
        persona.setSexo(etSexo.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("persona",persona);
        setResult(RESULT_OK,intent);
        finish();
    }
}
