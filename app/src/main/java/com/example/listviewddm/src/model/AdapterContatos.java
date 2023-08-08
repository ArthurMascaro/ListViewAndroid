package com.example.listviewddm.src.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listviewddm.R;

import java.util.ArrayList;

public class AdapterContatos extends ArrayAdapter<Contato> {
    private Context context;
    private ArrayList<Contato> contatos;

    public AdapterContatos(Context context, ArrayList<Contato> contatos) {
        super(context, R.layout.item_lista, contatos);
        this.context = context;
        this.contatos = contatos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.item_lista, parent, false);

        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblEmail = itemView.findViewById(R.id.lblEmail);
        TextView lblTelefone = itemView.findViewById(R.id.lblTelefone);

        lblNome.setText(contatos.get(position).getNome());
        lblEmail.setText(contatos.get(position).getEmail());
        lblTelefone.setText(contatos.get(position).getTelefone());

        return itemView;
    }

}