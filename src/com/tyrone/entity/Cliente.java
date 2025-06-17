package com.tyrone.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un cliente del sistema de biblioteca.
 * <p>
 * Extiende la clase Usuario agregando un historial de préstamos realizados.
 * Mantiene registro de todos los libros que el cliente ha solicitado en préstamo.
 * </p>
 *
 * @author TuNombre
 * @version 1.0
 * @since 2023-11
 */
public class Cliente extends Usuario {
    private List<Prestamo> historialLibrosPrestados = new ArrayList<>();

    /**
     * Constructor por defecto que inicializa un cliente vacío.
     */
    public Cliente() {
    }

    /**
     * Constructor que crea un cliente a partir de datos básicos de usuario.
     *
     * @param usuario Objeto Usuario con los datos personales básicos
     */
    public Cliente(Usuario usuario) {
        super(
                usuario.getNombre(),
                usuario.getCedula(),
                usuario.getTelefono(),
                usuario.getDireccion()
        );
    }

    /**
     * Obtiene el historial completo de préstamos del cliente.
     *
     * @return Lista de objetos Prestamo con el historial
     */
    public List<Prestamo> getHistorialLibrosPrestados() {
        return historialLibrosPrestados;
    }

    /**
     * Agrega un nuevo préstamo al historial del cliente.
     *
     * @param prestamo Objeto Prestamo a agregar al historial
     */
    public void setHistorialLibrosPrestados(Prestamo prestamo) {
        historialLibrosPrestados.add(prestamo);
    }

    /**
     * Representación en cadena del cliente y su historial.
     *
     * @return String con los datos del cliente y su historial de préstamos
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nHistorial de préstamos: " + historialLibrosPrestados;
    }
}