package com.tyrone.controller;

import com.tyrone.entity.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de libros en el sistema de biblioteca.
 *
 * Esta clase maneja la lógica de negocio relacionada con el catálogo de libros,
 * incluyendo creación, consulta, modificación y eliminación de libros.
 *
 */
public class LibroController {
    private List<Libro> libros = new ArrayList<>();

    /**
     * Registra un nuevo libro en el sistema.
     *
     * @param libro El objeto Libro a registrar
     * @throws IllegalArgumentException Si el objeto libro es nulo
     */
    public void crearLibro(Libro libro) {
        if (libro != null) {
            libros.add(libro);
            System.out.println("Libro creado exitosamente.");
        } else {
            System.out.println("No se pudo crear el libro.");
        }
    }

    /**
     * Muestra todos los libros registrados en el sistema.
     *
     * Si no hay libros registrados, muestra un mensaje informativo.
     *
     */
    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros para mostrar.");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

    /**
     * Busca un libro por título o autor.
     *
     * @param algo Cadena que puede contener título o autor del libro a buscar
     * @return El libro encontrado o null si no se encuentra
     */
    public Libro buscarLibro(String algo) {
        if (!algo.isEmpty()) {
            try {
                // Búsqueda por título
                for (Libro l : libros) {
                    if (l.getTitulo().equalsIgnoreCase(algo)) {
                        System.out.println("Libro encontrado: ");
                        return l;
                    }
                }

                // Búsqueda por autor
                for (Libro l : libros) {
                    if (l.getAutor().equalsIgnoreCase(algo)) {
                        System.out.println("Libros del autor " + algo + " encontrado: ");
                        return l;
                    }
                }

                System.out.println("Libro no encontrado.");
            } catch (RuntimeException e) {
                System.out.println("Error en la búsqueda: " + e.getMessage());
            }
        } else {
            System.out.println("El campo de búsqueda está vacío.");
        }
        return null;
    }

    /**
     * Actualiza los datos de un libro existente.
     *
     * @param id ID del libro a actualizar
     * @param libro Objeto Libro con los nuevos datos
     */
    public void actualizarDatosLibro(Long id, Libro libro) {
        for (Libro l : libros) {
            if (l.getId().equals(id)) {
                if (libro.getTitulo() != null) {
                    l.setTitulo(libro.getTitulo());
                }
                if (libro.getAutor() != null) {
                    l.setAutor(libro.getAutor());
                }
                if (libro.getGenero() != null) {
                    l.setGenero(libro.getGenero());
                }
                if (libro.getEjemplares() != null) {
                    l.setEjemplares(libro.getEjemplares());
                }
                if (libro.getUbicacion() != null) {
                    l.setUbicacion(libro.getUbicacion());
                }
                System.out.println("Libro actualizado exitosamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    /**
     * Elimina un libro del sistema.
     *
     * @param id ID del libro a eliminar
     */
    public void eliminarLibro(Long id) {
        for (Libro l : libros) {
            if (l.getId().equals(id)) {
                libros.remove(l);
                System.out.println("Libro eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}