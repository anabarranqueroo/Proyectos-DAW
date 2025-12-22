package com.disfracesPepito.modelo;

import java.util.Date;

public class Disfraz {

    private int id;
    private String descripcion;
    private double precio;
    private Talla talla;
    private Disponibilidad d;
    private int descuento;
    private String categoria;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Disfraz(String descripcion, double precio, Talla talla, Disponibilidad d, int descuento, String categoria, Date fecha_inicio, Date fecha_fin) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.talla = talla;
        this.d = d;
        this.descuento = descuento;
        this.categoria = categoria;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Disfraz() {
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

    public int getDescuento() {
        return descuento;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
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

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioFinal() {
        return precio * (1 - (descuento / 100.0));
    }
}
