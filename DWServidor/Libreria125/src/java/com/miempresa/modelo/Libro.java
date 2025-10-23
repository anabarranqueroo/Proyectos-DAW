package com.miempresa.modelo;

public class Libro {
    private String titulo;
    private String autor;
    private double precio;
    private int paginas;
    private Genero genero;

    public Libro(String titulo, String autor, double precio, int paginas, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.paginas = paginas;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrecio() {
        return precio;
    }

    public int getPaginas() {
        return paginas;
    }

    public Genero getGenero() {
        return genero;
    }
    
    
}
