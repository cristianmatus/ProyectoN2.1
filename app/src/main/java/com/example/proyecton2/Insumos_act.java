package com.example.proyecton2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Clases.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private Spinner insumos;
    private TextView result;
    private RatingBar estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.insumosp);
        result = findViewById(R.id.resul);
        //recibo los extras
        Bundle bun = getIntent().getExtras();//recibo los etras y los guardo en un bundle
        String[] listado = bun.getStringArray("insumos");//recibo el arreglo por su referencia

        ArrayAdapter adapterInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adapterInsumos);
    }

    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();
        int precio = 0;

        for (int i = 0; i < opcion.length(); i++)
        {
            if (opcion.equals(in.getInsumos()[1]))
            {
                precio = in.anadirAdicional(in.getPrecios()[1], 350);
                estrella.setRating(i);
                break;
            }
        }
        result.setText("La opción es: " + opcion + "\nEl precio es: " + precio);
    }
}