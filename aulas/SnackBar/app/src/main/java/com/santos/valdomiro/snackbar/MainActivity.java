package com.santos.valdomiro.snackbar;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrir;

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

        btnAbrir = findViewById(R.id.btn_abrir);

        // LENGTH_LONG
//        btnAbrir.setOnClickListener(v -> {
//            Snackbar.make(
//                    v,
//                    "Botão pressionado",
//                    Snackbar.LENGTH_LONG
//            ).show();
//        });

        // LENGTH_INDEFINITE
        btnAbrir.setOnClickListener(v -> {
            Snackbar.make(
                    v,
                    "Botão pressionado",
//                    Snackbar.LENGTH_LONG
                    Snackbar.LENGTH_INDEFINITE
            ).setAction("Confirmar", v1 -> {
                btnAbrir.setText("Botão abrir modificado");
            }).setActionTextColor(
                    getResources().getColor(R.color.cor_texto)
            ).show();
        });

    }
}