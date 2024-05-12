package com.santos.valdomiro.bancosdedadossql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        
        // Cria o banco de dados
        SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
        try {
            // Cria uma tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");

            // Inserir dados
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Valdomiro', 33)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Maria', 35)");

            // Recuperar dados
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            // Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("DADOS -- ", "nome: " + cursor.getString(indiceNome));
                Log.i("DADOS -- ", "idade: " + cursor.getString(indiceIdade));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bancoDados.close();
        }
    }
}