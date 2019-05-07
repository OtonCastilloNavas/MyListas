package com.cam.mylistas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PersonaHolder>
{
    private List<Persona> personaList;
    private final OnItemClickListener onItemClickListener;


    public  interface OnItemClickListener
    {
        void onItemClick(int position);
    }

    public RvAdapter(List<Persona> personaList, OnItemClickListener onItemClickListener) {

        this.personaList = personaList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PersonaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view= inflater.inflate(R.layout.item_persona,viewGroup,false);

        PersonaHolder personaHolder = new PersonaHolder(view);
        return personaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaHolder personaHolder, int i) {
        //personaList.get(i);
        personaHolder.tvNombre.setText(personaList.get(i).getNombre());
        personaHolder.tvFechaNac.setText(personaList.get(i).getFechaNacimiento());
        personaHolder.tvSexo.setText(personaList.get(i).getSexo());
        personaHolder.tvDescripcion.setText(personaList.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return personaList.size();
    }


    public class PersonaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNombre;
        public TextView tvFechaNac;
        public TextView tvSexo;
        public TextView tvDescripcion;

        public PersonaHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.tvNombre = itemView.findViewById(R.id.tvNombre);
            this.tvFechaNac = itemView.findViewById(R.id.tvFechaNac);
            this.tvSexo = itemView.findViewById(R.id.tvSexo);
            this.tvDescripcion = itemView.findViewById(R.id.tvDescripcion);

        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}