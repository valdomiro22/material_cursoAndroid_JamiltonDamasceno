package com.santos.valdomiro.cardview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.santos.valdomiro.cardview.R;
import com.santos.valdomiro.cardview.adapter.AdapterPostagem;
import com.santos.valdomiro.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> listPostagens = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        // Definir layout
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerPostagem.setLayoutManager(layoutManager);

        prepararPostagens();

        // Definir adapter
        AdapterPostagem adapter = new AdapterPostagem(listPostagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagens() {
        listPostagens.add( new Postagem("Valdomiro Santos", "#tbt viagem", R.drawable.imagem1));
        listPostagens.add( new Postagem("Hotel JM", "Viaje, aproveite nossos descontos", R.drawable.imagem2));
        listPostagens.add( new Postagem("Maria Luiza", "#Paris!!", R.drawable.imagem3));
        listPostagens.add( new Postagem("Marcos Paulo", "Que foto linda!", R.drawable.imagem4));
    }
}