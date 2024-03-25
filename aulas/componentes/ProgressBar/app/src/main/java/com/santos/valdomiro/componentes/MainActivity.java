package com.santos.valdomiro.componentes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal, progressBarCircular;
    private int progresso = 0;

    @SuppressLint({"MissingInflatedId", "LocalSuppress", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        progressBarCircular = findViewById(R.id.progress_bar_circular);
        progressBarHorizontal = findViewById(R.id.progress_bar_horizontal);

        /*
            visible - padrão
            invisible - ocupa espaço, só não é visivel
            gone - é como se o elemento saice da tela
        */

        progressBarHorizontal.setMax(10);
        progressBarCircular.setVisibility(View.GONE);

        button.setOnClickListener(v -> {
            progresso += 1;
            progressBarHorizontal.setProgress(progresso);

            progressBarCircular.setVisibility(View.VISIBLE);
            if (progresso == 10) {
                progressBarCircular.setVisibility(View.GONE);
            }
        });

    }
}