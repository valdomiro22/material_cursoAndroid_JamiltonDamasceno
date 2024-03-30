package com.santos.valdomiro.ciclodevidaactivityes;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

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

        Log.d("siclo_de_vida", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("siclo_de_vida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("siclo_de_vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("siclo_de_vida", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("siclo_de_vida", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("siclo_de_vida", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("siclo_de_vida", "onDestroy");
    }
}