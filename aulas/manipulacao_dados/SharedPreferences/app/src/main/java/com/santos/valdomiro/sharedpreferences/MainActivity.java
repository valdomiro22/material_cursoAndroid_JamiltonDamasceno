package com.santos.valdomiro.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private Button btnSalvar;
    private TextView txtResultado;

    private static final String ARQUIVO_PREFERENCES = "arquivoPreferences";

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

        editNome = findViewById(R.id.edit_nome);
        btnSalvar = findViewById(R.id.btn_salvar);
        txtResultado = findViewById(R.id.txt_resultado);

        btnSalvar.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCES, 0);
            SharedPreferences.Editor editor = preferences.edit();

            if (editNome.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Preencha o campo", Toast.LENGTH_SHORT).show();
            } else {
                String nome = editNome.getText().toString();
                editor.putString("nome", nome);
                editor.apply();

                txtResultado.setText("Olá " + nome);
            }
        });

        // Recuperar dados
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCES, 0);
        if (preferences.contains("nome")) {
            String nome = preferences.getString("nome", "indefinido");
            txtResultado.setText("Olá " + nome);
        } else {
            txtResultado.setText("Usuário não definido");
        }
    }
}