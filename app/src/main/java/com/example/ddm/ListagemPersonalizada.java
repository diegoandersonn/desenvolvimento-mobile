package com.example.ddm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListagemPersonalizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listagem_personalizada);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(new Jogador("Calleri", "São Paulo", 31));
        jogadores.add(new Jogador("Lucas Moura", "São Paulo", 33));
        jogadores.add(new Jogador("Oscar", "São Paulo", 35));
        jogadores.add(new Jogador("Pablo Maia", "São Paulo", 22));
        ArrayAdapter<Jogador> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jogadores);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListagemPersonalizada.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}