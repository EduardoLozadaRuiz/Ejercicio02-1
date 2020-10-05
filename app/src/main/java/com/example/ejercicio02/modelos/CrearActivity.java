package com.example.ejercicio02.modelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicio02.R;

public class CrearActivity extends AppCompatActivity {

    private EditText txtTitulo, txtContenido;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        txtTitulo = findViewById(R.id.txtTituloNotaCrear);
        txtContenido = findViewById(R.id.txtContenidoCrear);
        btnGuardar = findViewById(R.id.btnGuardarCrear);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}