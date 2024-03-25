package com.santos.valdomiro.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private SwitchMaterial aSwitch;
    private ToggleButton toggleButton;
    private TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnEnviar = findViewById(R.id.btn_enviar);
        aSwitch = findViewById(R.id.switch1);
        toggleButton = findViewById(R.id.toggleButton);
        textView = findViewById(R.id.txt_resultado);

        btnEnviar.setOnClickListener(v -> {
            String texto = "";

            if (aSwitch.isChecked()) {
                texto = "Lembrar senha: " + aSwitch.isChecked();
            }

            if (toggleButton.isChecked()) {
                texto += "\nAtivado";
            }

            textView.setText(texto);
        });
    }
}