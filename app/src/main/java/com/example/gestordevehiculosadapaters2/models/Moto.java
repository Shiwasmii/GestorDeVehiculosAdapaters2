package com.example.gestordevehiculosadapaters2.models;

public class Moto extends Vehiculo{
    public int cilindradaCC = 0;
    public String tipoManejo = "";
    public Moto(String marca, String modelo, int anioFabricacion, Double precioBase, Double kilometraje, int cilindradaCC, String tipoManejo) {
        super(marca, modelo, anioFabricacion, precioBase, kilometraje);
        this.cilindradaCC = cilindradaCC;
        this.tipoManejo = tipoManejo;
    }
}