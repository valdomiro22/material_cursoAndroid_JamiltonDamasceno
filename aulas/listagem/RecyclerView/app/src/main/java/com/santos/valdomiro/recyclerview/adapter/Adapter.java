package com.santos.valdomiro.recyclerview.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santos.valdomiro.recyclerview.R;
import com.santos.valdomiro.recyclerview.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private final List<Filme> listFilmes;

    public Adapter(List<Filme> lista) {
        listFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listFilmes.get(position);
        holder.txtTitulo.setText(filme.getTitulo());
        holder.txtGenero.setText(filme.getGenero());
        holder.txtAno.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        return listFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo;
        TextView txtAno;
        TextView txtGenero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.txt_titulo);
            txtAno = itemView.findViewById(R.id.txt_ano);
            txtGenero = itemView.findViewById(R.id.txt_genero);


        }
    }
}
