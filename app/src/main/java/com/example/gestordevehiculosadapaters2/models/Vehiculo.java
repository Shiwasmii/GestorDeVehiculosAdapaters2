package com.example.gestordevehiculosadapaters2.models;

public class Vehiculo {
    public String marca = "";
    public String modelo = "";
    public int anioFabricacion = 0;
    public Double precioBase = 0.00;
    public Double kilometraje = 0.00;

    public Vehiculo(String marca, String modelo, int anioFabricacion, Double precioBase, Double kilometraje){
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.precioBase = precioBase;
        this.kilometraje = kilometraje;
    }

}
