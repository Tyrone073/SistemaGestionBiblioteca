package com.tyrone.controller;

import com.tyrone.entity.Cliente;
import com.tyrone.entity.Prestamo;
import com.tyrone.enums.Estado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de préstamos en el sistema de biblioteca.
 *
 * Esta clase maneja la lógica de negocio relacionada con los préstamos de libros,
 * incluyendo creación, consulta, modificación y finalización de préstamos.
 *
 */
public class PrestamoController {
    private List<Prestamo> prestamos = new ArrayList<>();

    /**
     * Crea un nuevo préstamo en el sistema.
     *
     * @param prestamo El objeto Prestamo a crear
     * @throws IllegalArgumentException Si el préstamo no tiene libros asociados
     */
    public void crearPrestamo(Prestamo prestamo) {
        if (!prestamo.getDetallesLibros().isEmpty()) {
            prestamos.add(prestamo);
            Cliente cliente = prestamo.getCliente();
            cliente.setHistorialLibrosPrestados(prestamo);
            System.out.println("Prestamo creado exitosamente.");
            System.out.println(prestamo);
        } else {
            System.out.println("No se pudo crear el prestamo.");
        }
    }

    /**
     * Muestra todos los préstamos registrados en el sistema.
     */
    public void mostrarTodosLosPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos para mostrar.");
        } else {
            for (int i = 0; i < prestamos.size(); i++) {
                Prestamo p = prestamos.get(i);
                System.out.println(p);
            }
        }
    }

    /**
     * Muestra solo los préstamos que están activos o atrasados.
     */
    public void mostrarPrestamosActivos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos para mostrar.");
        } else {
            for (int i = 0; i < prestamos.size(); i++) {
                Prestamo p = prestamos.get(i);
                if (p.getEstado() == Estado.ACTIVO || p.getEstado() == Estado.ATRASADO) {
                    System.out.println(p);
                }
            }
        }
    }

    /**
     * Busca un préstamo por ID, cédula del cliente o fecha de préstamo.
     *
     * @param algo Cadena que puede contener ID, cédula o fecha (formato dd-MM-yyyy)
     * @return El préstamo encontrado o null si no se encuentra
     */
    public Prestamo buscarPrestamo(String algo) {
        if (!algo.isEmpty()) {
            boolean encontrado = false;

            // Búsqueda por ID
            try {
                Long idBuscado = Long.parseLong(algo);
                for (Prestamo p : prestamos) {
                    if (p.getId().equals(idBuscado)) {
                        System.out.println("Préstamo encontrado por ID: ");
                        encontrado=true;
                        return p;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró ningún préstamo con ese ID.");
                    return null;
                }
            } catch (NumberFormatException e) {
                // Continuar con otros tipos de búsqueda
            }

            // Búsqueda por cédula
            try {
                int cedula = Integer.parseInt(algo);
                for (Prestamo p : prestamos) {
                    if (p.getCliente().getCedula() == cedula) {
                        System.out.println("Prestamo encontrado por cedula: ");
                        encontrado=true;
                        return p;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró ningún préstamo con esa cédula.");
                }
            } catch (NumberFormatException e) {
                // Continuar con otros tipos de búsqueda
            }

            // Búsqueda por fecha
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                formato.setLenient(false);
                Date fechaBuscada = formato.parse(algo);

                for (Prestamo p : prestamos) {
                    if (p.getFechaPrestamo().equals(fechaBuscada)) {
                        System.out.println("Prestamo encontrado por fecha: ");
                        encontrado = true;
                        return p;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontraron préstamos con esa fecha.");
                }
            } catch (ParseException e) {
                System.out.println("No se reconoció el valor como ID, cédula ni fecha válida.");
            }
        } else {
            System.out.println("El campo de búsqueda está vacío.");
        }
        return null;
    }

    /**
     * Modifica los datos de un préstamo existente.
     *
     * @param id ID del préstamo a modificar
     * @param prestamo Objeto Prestamo con los nuevos datos
     */
    public void modificarPrestamo(Long id, Prestamo prestamo) {
        for (Prestamo p : prestamos) {
            if (p.getId().equals(id)) {
                if (prestamo.getDetallesLibros() != null) {
                    p.setDetallesLibros(prestamo.getDetallesLibros());
                }

                if (prestamo.getFechaDevolucion() != null) {
                    p.setFechaDevolucion(prestamo.getFechaDevolucion());
                }

                System.out.println("Prestamo modificado exitosamente.");
                return;
            }
        }
        System.out.println("Prestamo no encontrado.");
    }

    /**
     * Marca un préstamo como completado.
     *
     * @param id ID del préstamo a finalizar
     */
    public void finalizarPrestamo(Long id) {
        for (Prestamo p : prestamos) {
            if (p.getId().equals(id) && (p.getEstado() == Estado.ATRASADO || p.getEstado() == Estado.ACTIVO)) {
                p.setEstado(Estado.COMPLETADO);
                System.out.println("Préstamo " + id + " completado exitosamente.");
                return;
            }
        }
        System.out.println("Prestamo no encontrado.");
    }

    /**
     * Elimina un préstamo del sistema.
     *
     * @param id ID del préstamo a eliminar
     */
    public void eliminarPrestamo(Long id) {
        for (Prestamo p : prestamos) {
            if (p.getId().equals(id)) {
                prestamos.remove(p);
                System.out.println("Prestamo eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Prestamo no encontrado.");
    }
}