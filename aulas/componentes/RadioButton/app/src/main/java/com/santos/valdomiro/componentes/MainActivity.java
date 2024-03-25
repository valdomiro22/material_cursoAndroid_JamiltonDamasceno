package com.santos.valdomiro.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbMasculino, rbFeminino;
    private TextView txtResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btn_enviar);
        txtResultado = findViewById(R.id.txt_resultado);
        rbMasculino = findViewById(R.id.rb_masculino);
        rbFeminino = findViewById(R.id.rb_feminino);

        btnEnviar.setOnClickListener(v -> {
            radioButton();

        });
    }

    public void radioButton() {
        String texto = "";

        if (rbMasculino.isChecked()) {
            texto = rbMasculino.getText() + " \n";
        }

        if (rbFeminino.isChecked()) {
            texto = rbFeminino.getText() + " \n";
        }

        txtResultado.setText(texto);
    }
}
