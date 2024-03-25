package com.santos.valdomiro.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

//        button.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Toast aberto", Toast.LENGTH_LONG).show() );

        button.setOnClickListener(v -> {
            ImageView imagem = new ImageView(getApplicationContext());
            imagem.setImageResource(android.R.drawable.btn_star_big_on);

            TextView textView = new TextView(getApplicationContext());
            textView.setBackgroundResource(R.color.nova_cor);
            textView.setText("Mostrando o Toast");

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
//            toast.setView(imagem);
            toast.setView(textView);
            toast.show();
        });
    }
}