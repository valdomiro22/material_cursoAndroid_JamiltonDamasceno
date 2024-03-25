package com.santos.valdomiro.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbMasculino, rbFeminino;
    private RadioGroup radioGroup;
    private TextView txtResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txt_resultado);
        rbMasculino = findViewById(R.id.rb_masculino);
        rbFeminino = findViewById(R.id.rb_feminino);
        radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_masculino) {
                txtResultado.setText(rbMasculino.getText());
            } else if (checkedId == R.id.rb_feminino) {
                txtResultado.setText(rbFeminino.getText());
            }
        });
    }
}
