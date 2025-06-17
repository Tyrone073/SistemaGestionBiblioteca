package com.tyrone.entity;

/**
 * Representa los detalles de un libro en un préstamo, incluyendo la cantidad de ejemplares.
 * Cada instancia tiene un ID único generado automáticamente.
 */
public class DetallesLibros {
    private static long contador = 1;
    private Long id;
    private Libro libro;
    private Integer cantidad;

    /**
     * Constructor por defecto que crea un detalle vacío.
     */
    public DetallesLibros() {
    }

    /**
     * Constructor que inicializa los detalles con un libro y cantidad.
     * @param libro El libro asociado a estos detalles
     * @param cantidad La cantidad de ejemplares del libro
     */
    public DetallesLibros(Libro libro, Integer cantidad) {
        this.id = contador++;
        this.libro = libro;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ID único del detalle.
     * @return El ID del detalle
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del detalle.
     * @param id El nuevo ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el libro asociado.
     * @return El libro de estos detalles
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Establece el libro asociado.
     * @param libro El nuevo libro a asignar
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Obtiene la cantidad de ejemplares.
     * @return La cantidad actual
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de ejemplares.
     * @param cantidad La nueva cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Representación en String de los detalles del libro.
     * @return String con título, autor y cantidad
     */
    @Override
    public String toString() {
        return "\nTitulo: " + libro.getTitulo() + " Autor: " + libro.getAutor() +
                "\ncantidad: " + cantidad;
    }
}