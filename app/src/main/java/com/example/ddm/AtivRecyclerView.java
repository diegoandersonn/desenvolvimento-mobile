package com.example.ddm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AtivRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ativ_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerViewList);
        ArrayList<Planeta> planetas = new ArrayList<>();
        planetas.add(new Planeta("MERCÚRIO",R.drawable.mercury));
        planetas.add(new Planeta("VÊNUS",R.drawable.venus));
        planetas.add(new Planeta("TERRA",R.drawable.earth));
        planetas.add(new Planeta("MARTE",R.drawable.mars));
        planetas.add(new Planeta("JÚPITER",R.drawable.jupter));
        planetas.add(new Planeta( "SATURNO", R.drawable.saturn));
        planetas.add(new Planeta("URANO",R.drawable.uranus));
        planetas.add((new Planeta("SOL ",R.drawable.sun)));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, R.layout.planeta, planetas);
        recyclerView.setAdapter(recyclerViewAdapter);
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AtivRecyclerView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}