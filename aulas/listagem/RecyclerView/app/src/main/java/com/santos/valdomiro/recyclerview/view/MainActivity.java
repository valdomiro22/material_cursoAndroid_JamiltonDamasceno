package com.santos.valdomiro.recyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.santos.valdomiro.recyclerview.R;
import com.santos.valdomiro.recyclerview.RecyclerItemClickListener;
import com.santos.valdomiro.recyclerview.adapter.Adapter;
import com.santos.valdomiro.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        criarFilmes();

        // Configurar Adapter
        Adapter adapter = new Adapter(filmes);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = filmes.get(position);

                            Toast.makeText(getApplicationContext(), filme.getTitulo(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Toast.makeText(getApplicationContext(), "Click longo", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            Toast.makeText(getApplicationContext(), "Item pressionado", Toast.LENGTH_SHORT).show();

                        }
                    }
            )
        );
    }

    public void criarFilmes() {
        filmes.add(new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017"));
        filmes.add(new Filme("Mulher Maravilha", "Fantasia", "2017"));
        filmes.add(new Filme("Liga da Justiça", "Ficão", "2017"));
        filmes.add(new Filme("Capitão América - Guerra Civíl", "Aventura/ficção", "2016"));
        filmes.add(new Filme("It: A Coisa", "Drama/terror", "2017"));
        filmes.add(new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017"));
        filmes.add(new Filme("A Bela e a Fera", "Romance", "2017"));
        filmes.add(new Filme("Meu malvado favorito 3", "Comédia", "2017"));
        filmes.add(new Filme("Carros 3", "Comédia", "2017"));
    }
}