package com.example.gestordevehiculosadapaters2.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gestordevehiculosadapaters2.R;

public class DetalleVehiculoActivity extends AppCompatActivity {

    private TextView tvTitulo, tvDescripcion;
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_vehiculo);

        tvTitulo = findViewById(R.id.tvTituloDetalle);
        tvDescripcion = findViewById(R.id.tvDescripcionDetalle);
        ivImagen = findViewById(R.id.ivImagenDetalle);

        // Obtener datos del Intent
        String titulo = getIntent().getStringExtra("titulo");
        String descripcion = getIntent().getStringExtra("descripcion");
        int imagenRes = getIntent().getIntExtra("imagen", R.drawable.iconauto);

        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);
        ivImagen.setImageResource(imagenRes);
    }
}