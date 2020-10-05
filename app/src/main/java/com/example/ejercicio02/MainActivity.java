package com.example.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ejercicio02.modelos.CrearActivity;
import com.example.ejercicio02.modelos.Nota;

public class MainActivity extends AppCompatActivity {

    private final int CREAR_NOTA =1;
    private LinearLayout contenedorHorizontal;
    private TextView txtTituloNota;
    private Button btnEliminar, btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenedorHorizontal = findViewById(R.id.contenedorMain);
        btnCrear = findViewById(R.id.btnCrearMain);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearActivity.class);
                startActivityForResult(intent, CREAR_NOTA);
            }
        });
    }
}