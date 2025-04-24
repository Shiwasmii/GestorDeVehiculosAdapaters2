package com.example.gestordevehiculosadapaters2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestordevehiculosadapaters2.R;
import com.example.gestordevehiculosadapaters2.adapters.NormalAdapters;
import com.example.gestordevehiculosadapaters2.models.AutoNuevo;
import com.example.gestordevehiculosadapaters2.models.Item;
import com.example.gestordevehiculosadapaters2.models.Moto;
import com.example.gestordevehiculosadapaters2.models.MotoModificada;
import com.example.gestordevehiculosadapaters2.models.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class VehiculosActivity extends AppCompatActivity implements NormalAdapters.OnItemActionListener{
    private RecyclerView recyclerView;
    private List<AutoNuevo> autoNuevos;
    private NormalAdapters adapter;
    private List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehiculos);

        recyclerView = findViewById(R.id.recyclerView);
        initItems();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NormalAdapters(items, this);
        recyclerView.setAdapter(adapter);
    }

    private void initItems() {
        items = new ArrayList<>();

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new AutoNuevo("Toyota", "Corolla", 2022, 20000.0, 0.0, 3, 1000.0));
        vehiculos.add(new AutoNuevo("Honda", "Civic", 2023, 22000.0, 0.0, 4, 1500.0));
        vehiculos.add(new Moto("Yamaha", "FZ", 2021, 3000.0, 5000.0, 150, "Manual"));
        vehiculos.add(new Moto("Bajaj", "Dominar", 2022, 4000.0, 3000.0, 400, "Manual"));
        vehiculos.add(new MotoModificada("Harley-Davidson", "Iron 883", 2020, 9000.0, 8000.0, 883, "Manual", "Escape deportivo"));
        vehiculos.add(new MotoModificada("Ducati", "Monster", 2019, 12000.0, 6000.0, 937, "Manual", "Estética personalizada"));

        for (Vehiculo v : vehiculos) {
            String title = v.marca + " " + v.modelo;
            String description = "";
            int imageRes = R.drawable.iconauto; // Default

            if (v instanceof AutoNuevo) {
                AutoNuevo auto = (AutoNuevo) v;
                description = "Año: " + auto.anioFabricacion +
                        ", Garantía: " + auto.garantiaAnios + " años, " +
                        "Descuento: $" + auto.descuentoPromocional;
                imageRes = R.drawable.iconauto;
            } else if (v instanceof MotoModificada) {
                MotoModificada motoMod = (MotoModificada) v;
                description = "Año: " + motoMod.anioFabricacion +
                        ", Modificación: " + motoMod.tipoModificacion;
                imageRes = R.drawable.moto_modificada;
            } else if (v instanceof Moto) {
                Moto moto = (Moto) v;
                description = "Año: " + moto.anioFabricacion +
                        ", Cilindrada: " + moto.cilindradaCC + "cc, Tipo: " + moto.tipoManejo;
                imageRes = R.drawable.moto;
            }

            items.add(new Item(title, description, imageRes));
        }

        adapter = new NormalAdapters(items, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(Item item, int position) {
        Toast.makeText(this, "Seleccionaste: " + item.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActionButtonClick(Item item, int position) {
        Intent intent = new Intent(this, DetalleVehiculoActivity.class);
        intent.putExtra("titulo", item.getTitle());
        intent.putExtra("descripcion", item.getDescription());
        intent.putExtra("imagen", item.getImageResource());
        startActivity(intent);
    }
}