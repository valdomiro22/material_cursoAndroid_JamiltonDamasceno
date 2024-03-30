package com.santos.valdomiro.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santos.valdomiro.cardview.R;
import com.santos.valdomiro.cardview.model.Postagem;

import java.util.List;

public class AdapterPostagem extends RecyclerView.Adapter<AdapterPostagem.MinhaViewHolder> {
    List<Postagem> listPostagens;
    public AdapterPostagem(List<Postagem> lista) {
        listPostagens = lista;
    }

    @NonNull
    @Override
    public MinhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_postagens, parent, false);
        return new MinhaViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MinhaViewHolder holder, int position) {
        Postagem postagem = listPostagens.get(position);

        holder.txtNome.setText(postagem.getNome());
        holder.txtPostagem.setText(postagem.getPostagem());
        holder.imgPostagem.setImageResource(postagem.getImagem());
    }

    @Override
    public int getItemCount() {
        return listPostagens.size();
    }

    public class MinhaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNome;
        private TextView txtPostagem;
        private ImageView imgPostagem;

        public MinhaViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txt_nome);
            txtPostagem = itemView.findViewById(R.id.txt_postagem);
            imgPostagem = itemView.findViewById(R.id.img_postagem);
        }
    }
}
