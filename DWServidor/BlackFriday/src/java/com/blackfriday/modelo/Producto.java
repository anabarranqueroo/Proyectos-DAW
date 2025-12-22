/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blackfriday.modelo;

import java.time.LocalDate;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int descuento;
    private String categoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Producto() {}

    public Producto(String nombre, double precio, int descuento, String categoria, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getDescuento() { return descuento; }
    public void setDescuento(int descuento) { this.descuento = descuento; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    
    public double getPrecioFinal() {
        return precio * (1 - (descuento / 100.0));
    }
}