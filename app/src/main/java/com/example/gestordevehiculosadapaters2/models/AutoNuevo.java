package com.example.gestordevehiculosadapaters2.models;

public class AutoNuevo extends Vehiculo{
    public int garantiaAnios = 0;
    public Double descuentoPromocional = 0.00;
    public AutoNuevo(String marca, String modelo, int anioFabricacion, Double precioBase, Double kilometraje, int garantiaAnios, Double descuentoPromocional) {
        super(marca, modelo, anioFabricacion, precioBase, kilometraje);
        this.garantiaAnios = garantiaAnios;
        this.descuentoPromocional = descuentoPromocional;
    }
}
