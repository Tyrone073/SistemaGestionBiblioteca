package com.tyrone.entity;

public class DetallesLibros {
    private static long contador = 1;
    private Long id;
    private Libro libro;
    private Integer cantidad;

    public DetallesLibros() {
    }

    public DetallesLibros(Libro libro, Integer cantidad) {
        this.id = contador++;
        this.libro = libro;
        this.cantidad = cantidad;
    }
}
