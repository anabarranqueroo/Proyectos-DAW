
package com.disfracesPepito.modelo;


public class Disfraz {
        private String descripcion;
        private double precio;
        private Talla talla;
        private Disponibilidad d;

    public Disfraz(String descripcion, double precio, Talla talla, Disponibilidad d) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.talla = talla;
        this.d = d;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Talla getTalla() {
        return talla;
    }

    public Disponibilidad getD() {
        return d;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public void setD(Disponibilidad d) {
        this.d = d;
    }
        
        
        
}
