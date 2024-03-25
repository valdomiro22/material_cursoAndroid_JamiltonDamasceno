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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textResultado;

    @SuppressLint({"MissingInflatedId", "LocalSuppress", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        seekBar = findViewById(R.id.seekBar2);
        textResultado = findViewById(R.id.textResultado);

        seekBar.setMax(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textResultado.setText("onProgressChanged: " + progress + "/" + seekBar.getMax());
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                textResultado.setText("onStartTrackingTouch: ");

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                textResultado.setText("onStopTrackingTouch: ");

            }
        });

        button.setOnClickListener(v -> {
            textResultado.setText("Escolhido: " + seekBar.getProgress());
        });

    }
}