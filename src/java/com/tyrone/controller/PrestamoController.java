package java.com.tyrone.controller;

import java.com.tyrone.entity.Cliente;
import java.com.tyrone.entity.Prestamo;
import java.com.tyrone.enums.Estado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrestamoController {
    private List<Prestamo> prestamos = new ArrayList<>();

    public void crearPrestamo(Prestamo prestamo) {
        if (!prestamo.getDetallesLibros().isEmpty()) {
            prestamos.add(prestamo);
            Cliente cliente = prestamo.getCliente();
            cliente.setHistorialLibrosPrestados(prestamo);
            System.out.println("Prestamo creado exitosamente.");
            System.out.println(prestamo);
        }
        System.out.println("No se pudo crear el prestamo.");
    }

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

    public void buscarPrestamo(String algo) {
        if (!algo.isEmpty()) {
            boolean encontrado = false;
            // Intentar buscar por ID
            try {
                Long idBuscado = Long.parseLong(algo);
                for (Prestamo p : prestamos) {
                    if (p.getId().equals(idBuscado)) {
                        System.out.println("Préstamo encontrado por ID: " + p);
                        return;
                    }
                }
                System.out.println("No se encontró ningún préstamo con ese ID.");
                return;
            } catch (NumberFormatException e) {
                // No es un ID
            }

            try {
                int cedula = Integer.parseInt(algo);
                for (Prestamo p : prestamos) {
                    if (p.getCliente().getCedula() == cedula) {
                        System.out.println(p);
                        encontrado=true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró ningún préstamo con esa cédula.");
                }
            } catch (NumberFormatException e) {
                // No es una cédula numérica
            }

            // Intentar buscar por fecha
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                formato.setLenient(false); // Para que valide bien fechas
                Date fechaBuscada = formato.parse(algo);

                for (Prestamo p : prestamos) {
                    if (p.getFechaPrestamo().equals(fechaBuscada) || p.getFechaDevolucion().equals(fechaBuscada)) {
                        System.out.println(p);
                        encontrado = true;
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
    }


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
