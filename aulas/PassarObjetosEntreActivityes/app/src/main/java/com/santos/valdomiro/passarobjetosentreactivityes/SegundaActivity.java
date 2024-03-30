package com.santos.valdomiro.passarobjetosentreactivityes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNome = findViewById(R.id.txt_nome);
        txtIdade = findViewById(R.id.txt_idade);

        // Recuperar dados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome", "--");
        int idade = dados.getInt("idade", -1);

        // Recuperar objeto
        Usuario usuario = (Usuario) dados.getSerializable("obj");

        assert usuario != null;
        txtNome.setText(usuario.getNome());
        txtIdade.setText(usuario.getEmail());
    }
}