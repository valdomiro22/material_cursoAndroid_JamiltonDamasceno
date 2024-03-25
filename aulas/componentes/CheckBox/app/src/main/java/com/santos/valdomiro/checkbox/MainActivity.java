package com.santos.valdomiro.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkVerde, checkBranco, checkVermelho;
    private TextView txtResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btn_enviar);
        checkBranco = findViewById(R.id.check_branco);
        checkVerde = findViewById(R.id.check_verde);
        checkVermelho = findViewById(R.id.check_vermelho);
        txtResultado = findViewById(R.id.txt_resultado);

        btnEnviar.setOnClickListener(v -> {
            checkBox();
        });
    }

    public void checkBox() {
        String texto = "";

        if (checkVerde.isChecked()) {
            texto = checkVerde.getText() + " \n";
        }

        if (checkBranco.isChecked()) {
            texto += checkBranco.getText() + " \n";
        }

        if (checkVermelho.isChecked()) {
            texto += checkVermelho.getText() + " \n";
        }

        txtResultado.setText(texto);
    }
}