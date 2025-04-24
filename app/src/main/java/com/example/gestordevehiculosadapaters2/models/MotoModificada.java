package com.example.gestordevehiculosadapaters2.models;

public class MotoModificada extends Moto{
    public String tipoModificacion = "";
    public int  valor ;
    public MotoModificada(String marca, String modelo, int anioFabricacion, Double precioBase, Double kilometraje, int cilindradaCC, String tipoManejo, String tipoModificacion) {
        super(marca, modelo, anioFabricacion, precioBase, kilometraje, cilindradaCC, tipoManejo);
        this.tipoModificacion = tipoModificacion;
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
