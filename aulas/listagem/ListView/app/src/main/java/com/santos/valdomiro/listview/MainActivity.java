package com.santos.valdomiro.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] itens = {
            "Angra dos Reis",
            "Caldas Novas",
            "Campos do Jordão",
            "Costa do Sauípe",
            "Ilhéus",
            "Porto Seguro",
            "Tiradentes",
            "Praga",
            "Santiago",
            "Zurique",
            "Caribe",
            "Buenos Aires",
            "Budapeste",
            "Cancún",
            "Aruba"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listLocais);

        // Criar adapter para a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,  // Layout
                android.R.id.text1,  // id do textView dentro do layout
                itens  // lista que será listada
        );

        // Setar o Adapter no listView
        listView.setAdapter(adapter);

        // Adicionar click na lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listView.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}