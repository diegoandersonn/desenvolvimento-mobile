package com.example.ddm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Conversor extends AppCompatActivity {
    double valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnSend = findViewById(R.id.btnSend);
        Button btnBack = findViewById(R.id.btnBack);
        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText edText = findViewById(R.id.edText);
                TextView tvPeso = findViewById(R.id.tvPeso);
                TextView tvEuro = findViewById(R.id.tvEuro);
                TextView tvLibra = findViewById(R.id.tvLibra);
                TextView tvDolar = findViewById(R.id.tvDolar);
                valor = Double.parseDouble(edText.getText().toString()) * 0.18;
                tvDolar.setText(String.format("%.2f Dólares", valor));
                valor = Double.parseDouble(edText.getText().toString()) * 180;
                tvPeso.setText(String.format("%.2f Pesos", valor));
                valor = Double.parseDouble(edText.getText().toString()) * 0.16;
                tvEuro.setText(String.format("%.2f Euros", valor));
                valor = Double.parseDouble(edText.getText().toString()) * 0.14;
                tvLibra.setText(String.format("%.2f Libras", valor));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Conversor.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}