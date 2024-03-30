package com.santos.valdomiro.utilizandofragments.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.santos.valdomiro.utilizandofragments.R;
import com.santos.valdomiro.utilizandofragments.fragment.ContatosFragment;
import com.santos.valdomiro.utilizandofragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnConversas, btnContatos;
    private FrameLayout frameConteudo;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnConversas = findViewById(R.id.btn_conversas);
        btnContatos = findViewById(R.id.btn_contatos);
        frameConteudo = findViewById(R.id.frame_conteudo);

        conversasFragment = new ConversasFragment();

        // Exibir os fragments
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_conteudo, conversasFragment);
        transaction.commit();

        btnContatos.setOnClickListener(v -> {
            contatosFragment = new ContatosFragment();
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.frame_conteudo, contatosFragment);
            transaction1.commit();
        });

        btnConversas.setOnClickListener(v -> {
            conversasFragment = new ConversasFragment();
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.frame_conteudo, conversasFragment);
            transaction1.commit();
        });
    }
}