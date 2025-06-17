package com.tyrone.entity;

import com.tyrone.enums.Genero;

/**
 * Representa un libro en el sistema de biblioteca con sus atributos básicos y ubicación física.
 * Cada libro tiene un ID único generado automáticamente.
 */
public class Libro {
    private static long contador = 1;
    private Long id;
    private String titulo;
    private String autor;
    private Genero genero;
    private Integer ejemplares;
    private String ubicacion;

    /**
     * Constructor por defecto que crea un libro sin información.
     */
    public Libro() {
    }

    /**
     * Constructor que inicializa un libro con todos sus datos.
     * @param titulo El título del libro
     * @param autor El autor del libro
     * @param genero El género literario del libro
     * @param ejemplares Cantidad de ejemplares disponibles
     * @param ubicacion Ubicación física en la biblioteca
     */
    public Libro(String titulo, String autor, Genero genero, Integer ejemplares, String ubicacion) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ejemplares = ejemplares;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el ID único del libro.
     * @return El ID del libro
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del libro.
     * @param id El nuevo ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     * @return El título actual
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para el libro.
     * @param titulo El nuevo título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     * @return El autor actual
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece un nuevo autor para el libro.
     * @param autor El nuevo autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el género del libro.
     * @return El género actual
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece un nuevo género para el libro.
     * @param genero El nuevo género
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la cantidad de ejemplares disponibles.
     * @return La cantidad de ejemplares
     */
    public Integer getEjemplares() {
        return ejemplares;
    }

    /**
     * Establece la cantidad de ejemplares disponibles.
     * @param ejemplares La nueva cantidad
     */
    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    /**
     * Obtiene la ubicación física del libro en la biblioteca.
     * @return La ubicación actual
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece una nueva ubicación física para el libro.
     * @param ubicacion La nueva ubicación
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Representación en String de la información del libro.
     * @return String con título, autor, género, ejemplares y ubicación
     */
    @Override
    public String toString() {
        return "\nLibro: " + titulo +
                "\nAutor: " + autor +
                "\nGenero: " + genero +
                "\nEjemplares: " + ejemplares +
                "\nUbicacion: " + ubicacion;
    }
}