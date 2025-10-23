
package com.cursosUniversitarios.modelo;

public class Curso {
    private String nombre;
    private String profesor;
    private int duracion;
    private int plazas;
    private Modalidad modalidad;

    public Curso(String nombre, String profesor, int duracion, int plazas, Modalidad modalidad) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.duracion = duracion;
        this.plazas = plazas;
        this.modalidad = modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getPlazas() {
        return plazas;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
    
    
}
