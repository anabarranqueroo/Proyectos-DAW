
package com.miempresa.modelo;

public class Receta {
    private String nombre;
    private String chef;
    private double tiempo;
    private int ingredientes;
    private TipoPlato tipo;

    public Receta(String nombre, String chef, double tiempo, int ingredientes, TipoPlato tipo) {
        this.nombre = nombre;
        this.chef = chef;
        this.tiempo = tiempo;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getChef() {
        return chef;
    }

    public double getTiempo() {
        return tiempo;
    }

    public int getIngredientes() {
        return ingredientes;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public void setIngredientes(int ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }
    
    
}
