package com.santos.valdomiro.componentes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "LocalSuppress", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Título da dialog");
            dialog.setMessage("Mensagem da dialog");

            dialog.setCancelable(false);
            dialog.setIcon(android.R.drawable.ic_btn_speak_now);

            dialog.setPositiveButton("Sim", (dialog1, which) -> Toast.makeText(getApplicationContext(), "Sim clicado", Toast.LENGTH_SHORT).show());

            dialog.setNegativeButton("Não", (dialog12, which) -> Toast.makeText(getApplicationContext(), "Não clicado", Toast.LENGTH_SHORT).show());

            dialog.create();
            dialog.show();
        });

    }
}