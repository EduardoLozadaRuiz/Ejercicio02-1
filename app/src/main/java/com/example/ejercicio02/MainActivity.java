package com.example.ejercicio02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ejercicio02.modelos.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  final int EDIT_NOTA = 2;
    private final int CREAR_NOTA = 1;
    private LinearLayout contenedor;
    private Button btnAgregar;

    //Variables modelos
    private ArrayList<Nota> listaNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        contenedor = findViewById(R.id.contenedor);
        btnAgregar = findViewById(R.id.btnAgregarMain);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearActivity.class);
                startActivityForResult(intent, CREAR_NOTA);
            }
        });
        listaNotas = new ArrayList<>();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == CREAR_NOTA && resultCode==RESULT_OK){
            if (data != null){
                final Nota nota = data.getExtras().getParcelable("NOTA");
                listaNotas.add(nota);
                final int posicion= listaNotas.size()-1;
                // Crear Textview
                TextView txtTitulo= new TextView(this);
                txtTitulo.setText(nota.getTitulo());
                txtTitulo.setTextColor(Color.BLUE);
                txtTitulo.setTextSize(24);
                txtTitulo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("POS",posicion);
                        bundle.putParcelable("NOTA", nota);
                        Intent intent = new Intent(MainActivity.this, EditarVerActivity.class);
                        intent.putExtras(bundle);
                        startActivityForResult(intent, EDIT_NOTA);
                    }
                });
                // Params layout
                LinearLayout.LayoutParams paramsTXT = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
                paramsTXT.setMargins(10,10,10,10);
                txtTitulo.setLayoutParams(paramsTXT);


                //Button
                Button btnEliminar = new Button(this);
                btnEliminar.setText("Eliminar");
                btnEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listaNotas.remove(posicion);
                        repintarNotas();
                    }
                });
                LinearLayout.LayoutParams paramsBTN = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
                paramsBTN.setMargins(10,10,10,10);
                btnEliminar.setLayoutParams(paramsTXT);

                //linear horizontal
                LinearLayout contenedorNota = new LinearLayout(this);
                contenedorNota.setOrientation(LinearLayout.HORIZONTAL);

                //Agregar los elementos a la vista
                contenedorNota.addView(txtTitulo);
                contenedorNota.addView(btnEliminar);

                contenedor.addView(contenedorNota);
            }
        }
    }

    private void repintarNotas() {
        contenedor.removeAllViews();
        for (int i = 0; i <listaNotas.size() ; i++) {
            final Nota nota = listaNotas.get(i);
            final int posicion= i;
            // Crear Textview
            TextView txtTitulo= new TextView(this);
            txtTitulo.setText(nota.getTitulo());
            txtTitulo.setTextColor(Color.BLUE);
            txtTitulo.setTextSize(24);
            txtTitulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("POS",posicion);
                    bundle.putParcelable("NOTA", nota);
                    Intent intent = new Intent(MainActivity.this, EditarVerActivity.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, EDIT_NOTA);
                }
            });
            // Params layout
            LinearLayout.LayoutParams paramsTXT = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
            paramsTXT.setMargins(10,10,10,10);
            txtTitulo.setLayoutParams(paramsTXT);


            //Button
            Button btnEliminar = new Button(this);
            btnEliminar.setText("Eliminar");
            btnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listaNotas.remove(posicion);
                    repintarNotas();
                }
            });
            LinearLayout.LayoutParams paramsBTN = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
            paramsBTN.setMargins(10,10,10,10);
            btnEliminar.setLayoutParams(paramsTXT);

            //linear horizontal
            LinearLayout contenedorNota = new LinearLayout(this);
            contenedorNota.setOrientation(LinearLayout.HORIZONTAL);

            //Agregar los elementos a la vista
            contenedorNota.addView(txtTitulo);
            contenedorNota.addView(btnEliminar);

            contenedor.addView(contenedorNota);
        }
    }
}