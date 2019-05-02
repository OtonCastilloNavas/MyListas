package com.cam.mylistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MiAdapterPersona extends ArrayAdapter {
    private  Context context;
    private int resource;
    private List<Persona> personaList;

    public MiAdapterPersona( Context context, int resource,  List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.personaList=objects;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v=inflater.inflate(this.resource,parent,false);

        TextView tvNombre= v.findViewById(R.id.tvNombre);
        TextView tvFechaNac = v.findViewById(R.id.tvFechaNac);
        TextView tvSexo= v.findViewById(R.id.tvSexo);
        TextView tvDescripcion= v.findViewById(R.id.tvDescripcion);

         tvNombre.setText(personaList.get(position).getNombre());
         tvFechaNac.setText(personaList.get(position).getFechaNacimiento());
         tvSexo.setText(personaList.get(position).getSexo());
         tvDescripcion.setText(personaList.get(position).getDescripcion());


        return v;
    }
}
