package com.tyrone.controller;
import com.tyrone.entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador principal que gestiona todas las operaciones del sistema de biblioteca.
 *
 * Esta clase coordina las operaciones CRUD para bibliotecarios, clientes, libros y préstamos,
 * actuando como fachada principal del sistema. También maneja la autenticación de bibliotecarios.
 *
 *
 */
public class BibliotecarioController {
    private final List<Bibliotecario> bibliotecarios = new ArrayList<>();
    private final ClienteController clienteController = new ClienteController();
    private final LibroController libroController = new LibroController();
    private final PrestamoController prestamoController = new PrestamoController();

    /**
     * Registra un nuevo bibliotecario en el sistema.
     *
     * @param bibliotecario El objeto Bibliotecario a registrar
     * @throws IllegalArgumentException Si los datos requeridos son nulos o si la cédula ya existe
     */
    public void crearBibliotecario(Bibliotecario bibliotecario) {
        if (bibliotecario.getCredenciales() != null && bibliotecario.getCargo() != null
                && bibliotecario.getFechaContratacion() != null) {

            for (Bibliotecario b : bibliotecarios) {
                if (b.getCedula() == bibliotecario.getCedula()) {
                    System.out.println("Bibliotecario con cédula existente en la base de datos.");
                    return;
                }
            }
            bibliotecarios.add(bibliotecario);
            System.out.println("Bibliotecario creado con éxito");
        } else {
            System.out.println("No se pudo crear el bibliotecario.");
        }
    }

    /**
     * Muestra todos los bibliotecarios registrados en el sistema.
     */
    public void mostrarBibliotecarios() {
        if (bibliotecarios.isEmpty()) {
            System.out.println("No hay bibliotecarios para mostrar.");
        } else {
            for (Bibliotecario b : bibliotecarios) {
                System.out.println(b);
            }
        }
    }

    /**
     * Busca un bibliotecario por su ID único.
     *
     * @param id ID del bibliotecario a buscar
     * @return El bibliotecario encontrado o null si no existe
     */
    public Bibliotecario buscarBibliotecarioPorId(Long id) {
        if (id == null) {
            System.out.println("El ID del bibliotecario no puede ser nulo.");
            return null;
        }

        for (Bibliotecario b : bibliotecarios) {
            if (b.getId().equals(id)) {
                System.out.println("Bibliotecario encontrado");
                return b;
            }
        }
        System.out.println("Bibliotecario no encontrado con ese ID.");
        return null;
    }

    /**
     * Actualiza los datos de un bibliotecario existente.
     *
     * @param id ID del bibliotecario a actualizar
     * @param bibliotecario Objeto con los nuevos datos
     */
    public void actualizarDatosBibliotecario(Long id, Bibliotecario bibliotecario) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getId().equals(id)) {
                if (bibliotecario.getCredenciales() != null) {
                    b.setCredenciales(bibliotecario.getCredenciales());
                }
                if (bibliotecario.getNombre() != null) {
                    b.setNombre(bibliotecario.getNombre());
                }
                if (bibliotecario.getCedula() != null) {
                    b.setCedula(bibliotecario.getCedula());
                }
                if (bibliotecario.getTelefono() != null) {
                    b.setTelefono(bibliotecario.getTelefono());
                }
                if (bibliotecario.getDireccion() != null) {
                    b.setDireccion(bibliotecario.getDireccion());
                }
                if (bibliotecario.getCargo() != null) {
                    b.setCargo(bibliotecario.getCargo());
                }
                if (bibliotecario.getFechaContratacion() != null) {
                    b.setFechaContratacion(bibliotecario.getFechaContratacion());
                }
                System.out.println("Bibliotecario actualizado exitosamente.");
                return;
            }
        }
        System.out.println("Bibliotecario no encontrado.");
    }

    /**
     * Realiza una eliminación lógica (desactivación) de un bibliotecario.
     *
     * @param id ID del bibliotecario a desactivar
     */
    public void eliminarBibliotecario(Long id) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getId().equals(id)) {
                b.setActivo(false);
                System.out.println("Bibliotecario eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Bibliotecario no encontrado.");
    }

    /* Métodos delegados para gestión de clientes */

    /**
     * Registra un nuevo cliente en el sistema.
     * @param cliente Objeto Cliente a registrar
     */
    public void registrarCliente(Cliente cliente) {
        clienteController.crearCliente(cliente);
    }

    /**
     * Muestra todos los clientes registrados.
     */
    public void mostrarClientes() {
        clienteController.mostrarClientes();
    }

    /**
     * Busca un cliente por cédula o nombre.
     * @param algo Cadena de búsqueda (cédula o nombre)
     * @return Cliente encontrado o null
     */
    public Cliente buscarCliente(String algo) {
        return clienteController.buscarCliente(algo);
    }

    /**
     * Actualiza los datos de un cliente existente.
     * @param id ID del cliente
     * @param cliente Objeto con nuevos datos
     */
    public void actualizarDatosCliente(Long id, Cliente cliente) {
        clienteController.actualizarDatosCliente(id, cliente);
    }

    /**
     * Elimina lógicamente un cliente.
     * @param id ID del cliente a eliminar
     */
    public void eliminarCliente(Long id) {
        clienteController.eliminarCliente(id);
    }

    /* Métodos delegados para gestión de libros */

    /**
     * Registra un nuevo libro en el sistema.
     * @param libro Objeto Libro a registrar
     */
    public void registrarLibro(Libro libro) {
        libroController.crearLibro(libro);
    }

    /**
     * Muestra todos los libros registrados.
     */
    public void mostrarLibros() {
        libroController.mostrarLibros();
    }

    /**
     * Busca un libro por título o autor.
     * @param algo Cadena de búsqueda (título o autor)
     * @return Libro encontrado o null
     */
    public Libro buscarLibro(String algo) {
        return libroController.buscarLibro(algo);
    }

    /**
     * Actualiza los datos de un libro existente.
     * @param id ID del libro
     * @param libro Objeto con nuevos datos
     */
    public void actualizarDatosLibro(Long id, Libro libro) {
        libroController.actualizarDatosLibro(id, libro);
    }

    /**
     * Elimina un libro del sistema.
     * @param id ID del libro a eliminar
     */
    public void eliminarLibro(Long id) {
        libroController.eliminarLibro(id);
    }

    /* Métodos delegados para gestión de préstamos */

    /**
     * Registra un nuevo préstamo en el sistema.
     * @param prestamo Objeto Prestamo a registrar
     */
    public void registrarPrestamolibro(Prestamo prestamo) {
        prestamoController.crearPrestamo(prestamo);
    }

    /**
     * Muestra todos los préstamos registrados.
     */
    public void mostrarTodosLosPrestamosLibros() {
        prestamoController.mostrarTodosLosPrestamos();
    }

    /**
     * Muestra solo los préstamos activos o atrasados.
     */
    public void mostrarPrestamosActivosLibros() {
        prestamoController.mostrarPrestamosActivos();
    }

    /**
     * Busca un préstamo por ID, cédula o fecha.
     * @param algo Cadena de búsqueda
     * @return Préstamo encontrado o null
     */
    public Prestamo buscarPrestamo(String algo) {
        return prestamoController.buscarPrestamo(algo);
    }

    /**
     * Modifica los datos de un préstamo existente.
     * @param id ID del préstamo
     * @param prestamo Objeto con nuevos datos
     */
    public void modificarPrestamo(Long id, Prestamo prestamo) {
        prestamoController.modificarPrestamo(id, prestamo);
    }

    /**
     * Finaliza un préstamo activo.
     * @param id ID del préstamo a finalizar
     */
    public void finalizarPrestamo(Long id) {
        prestamoController.finalizarPrestamo(id);
    }

    /**
     * Elimina un préstamo del sistema.
     * @param id ID del préstamo a eliminar
     */
    public void eliminarPrestamo(Long id) {
        prestamoController.eliminarPrestamo(id);
    }

    /**
     * Autentica un bibliotecario en el sistema.
     *
     * @param credenciales Objeto con usuario y contraseña
     * @return Bibliotecario autenticado o null si falla
     */
    public Bibliotecario autenticarBibliotecario(Credenciales credenciales) {
        if (credenciales != null) {
            for (Bibliotecario b : bibliotecarios) {
                if (b.getCredenciales().getUsuario().equals(credenciales.getUsuario())
                        && b.getCredenciales().getContrasena().equals(credenciales.getContrasena())) {
                    return b;
                }
            }
            System.out.println("Credenciales incorrectas.");
        } else {
            System.out.println("Credenciales vacías");
        }
        return null;
    }
}