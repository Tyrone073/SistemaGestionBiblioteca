package com.tyrone.entity;

import com.tyrone.enums.Genero;

public class Libro {
    private static long contador = 1;
    private Long id;
    private String titulo;
    private String autor;
    private Genero genero;
    private Integer ejemplares;
    private String ubicacion;

    public Libro() {
    }
    public Libro(String titulo, String autor, Genero genero, Integer ejemplares, String ubicacion) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ejemplares = ejemplares;
        this.ubicacion = ubicacion;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Integer getEjemplares() {
        return ejemplares;
    }
    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "\nLibro: " + titulo +
               "\nAutor: " + autor +
               "\nGenero: " + genero +
               "\nEjemplares: " + ejemplares +
               "\nUbicacion: " + ubicacion;
    }
}
