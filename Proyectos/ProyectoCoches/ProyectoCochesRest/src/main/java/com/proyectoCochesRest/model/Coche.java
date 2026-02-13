package com.proyectoCochesRest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La marca es obligatoria")
    @Column(nullable = false)
    private String marca;

    @JsonManagedReference
    @OneToMany(mappedBy = "coche", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Modelo> modelos = new ArrayList<>();

    @Past(message = "La fecha de fabricación debe ser anterior a hoy")
    private LocalDate anoFabricacion;

    @NotBlank(message = "El color es obligatorio")
    private String color;

    private double precio;

    public Coche() {
    }

    public Coche(String marca, LocalDate anoFabricacion, String color, double precio) {
        this.marca = marca;
        this.anoFabricacion = anoFabricacion;
        this.color = color;
        this.precio = precio;
    }

    public void addModelo(Modelo m) {
        m.setCoche(this);
        this.modelos.add(m);
    }

    public void removeModelo(Modelo m) {
        m.setCoche(null);
        this.modelos.remove(m);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public LocalDate getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(LocalDate anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
