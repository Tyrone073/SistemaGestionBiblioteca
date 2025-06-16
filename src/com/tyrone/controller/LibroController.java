package com.tyrone.controller;

import com.tyrone.entity.Libro;
import java.util.ArrayList;
import java.util.List;

public class LibroController {
    private List<Libro> libros = new ArrayList<>();

    public void crearLibro(Libro libro){
        if (libro != null){
            libros.add(libro);
            System.out.println("Libro creado exitosamente.");
        }else {
            System.out.println("No se pudo crear el libro.");
        }
    }
    public void mostrarLibros(){
        if (libros.isEmpty()){
            System.out.println("No hay libros para mostrar.");
        }else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }
    public void buscarLibro(String algo){
        if (!algo.isEmpty()){
            try {
                for (Libro l : libros) {
                    if (l.getTitulo().equals(algo)) {
                        System.out.println("Libro encontrado: " + l);
                        return;
                    }
                }
                System.out.println("Libro no encontrado.");
                return;
            } catch (RuntimeException _) {
            }
            try {
                for (Libro l : libros) {
                    if (l.getAutor().equals(algo)) {
                        System.out.println("Libros del autor "+ algo + " : " + l);
                        return;
                    }
                }
                System.out.println("Autor no encontrado.");
            }catch (RuntimeException e){
                System.out.println("Libro o autor inexistentes");
            }

        }else {
            System.out.println("El campo de búsqueda está vacío.");
        }
    }
    public void actualizarDatosLibro(Long id, Libro libro){
        for (Libro l : libros) {
            if (l.getId().equals(id)) {
                if (libro.getTitulo() != null) {
                    l.setTitulo(libro.getTitulo());
                }
                if (l.getAutor() != null) {
                    l.setAutor(libro.getAutor());
                }
                if (l.getGenero() != null) {
                    l.setGenero(libro.getGenero());
                }
                if (l.getEjemplares() != null) {
                    l.setEjemplares(libro.getEjemplares());
                }
                if (l.getUbicacion() != null) {
                    l.setUbicacion(libro.getUbicacion());
                }
                System.out.println("Libro actualizado exitosamente.");
            }else {
                System.out.println("Libro no encontrado.");
                return;
            }
        }

    }
    public void eliminarLibro(Long id){
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
