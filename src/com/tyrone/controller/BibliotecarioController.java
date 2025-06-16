package com.tyrone.controller;
import com.tyrone.entity.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecarioController  {
    private List<Bibliotecario> bibliotecarios = new ArrayList<>();
    private ClienteController clienteController = new ClienteController();
    private LibroController libroController = new LibroController();
    private PrestamoController prestamoController = new PrestamoController();


    public void crearBibliotecario(Bibliotecario bibliotecario) {
        if (bibliotecario.getCredenciales() != null && bibliotecario.getCargo() != null && bibliotecario.getFechaContratacion() != null) {
            for ( Bibliotecario b : bibliotecarios){
                if (b.getCedula() == bibliotecario.getCedula()){
                    System.out.println("Bibliotecario con cedula existente en la base de datos.");
                    return;
                }
            }
            bibliotecarios.add(bibliotecario);
            System.out.println("Bibliotecario creado con exito");
        }else {
            System.out.println("No se pudo crear el bibliotecario.");
        }
    }

    public void mostrarBibliotecarios() {
        if (bibliotecarios.isEmpty()) {
            System.out.println("No hay bibliotecarios para mostrar.");
        } else {
            for (int i = 0; i < bibliotecarios.size(); i++) {
                Bibliotecario b = bibliotecarios.get(i);
                System.out.println(b);
            }
        }
    }

    public Bibliotecario buscarBibliotecarioPorId(Long id) {
        if (id == null) {
            System.out.println("El ID del bibliotecario no puede ser nulo.");
        }else {
            for (Bibliotecario b : bibliotecarios){
                if (b.getId().equals(id)){
                    System.out.println("Bibliotecario encontrado");
                    return b;
                }
            }
            System.out.println("bibliotecario no encontrado con ese ID.");
        }

        return null;
    }

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

            }else {
                System.out.println("Bibliotecario no encontrado.");
            }
        }
    }

    public void eliminarBibliotecario(Long id) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getId().equals(id)) {
//                bibliotecarios.remove(b);
                b.setActivo(false);
                System.out.println("Bibliotecario eliminado exitosamente.");
                return;
            }else {
                System.out.println("Bibliotecario no encontrado.");
            }
        }
    }

    public void registrarCliente(Cliente cliente) {
        clienteController.crearCliente(cliente);
    }

    public void mostrarClientes() {
        clienteController.mostrarClientes();
    }

    public Cliente buscarCliente(String algo) {
        return clienteController.buscarCliente(algo);
    }

    public void actualizarDatosCliente(Long id, Cliente cliente) {
        clienteController.actualizarDatosCliente(id, cliente);
    }

    public void eliminarCliente(Long id) {
        clienteController.eliminarCliente(id);
    }

    public void registrarLibro(Libro libro) {
        libroController.crearLibro(libro);
    }

    public void mostrarLibros() {
        libroController.mostrarLibros();
    }

    public Libro buscarLibro(String algo) {
        return libroController.buscarLibro(algo);
    }

    public void actualizarDatosLibro(Long id, Libro libro) {
        libroController.actualizarDatosLibro(id, libro);
    }

    public void eliminarLibro(Long id) {
        libroController.eliminarLibro(id);
    }

    public void registrarPrestamolibro(Prestamo prestamo) {
        prestamoController.crearPrestamo(prestamo);
    }

    public void mostrarTodosLosPrestamosLibros() {
        prestamoController.mostrarTodosLosPrestamos();
    }
    public void mostrarPrestamosActivosLibros() {
        prestamoController.mostrarPrestamosActivos();
    }
    public Prestamo buscarPrestamo(String algo) {
        return  prestamoController.buscarPrestamo(algo);
    }
    public void modificarPrestamo(Long id, Prestamo prestamo) {
        prestamoController.modificarPrestamo(id, prestamo);
    }
    public void finalizarPrestamo(Long id) {
        prestamoController.finalizarPrestamo(id);
    }
    public void eliminarPrestamo(Long id) {
        prestamoController.eliminarPrestamo(id);
    }

    public Bibliotecario autenticarBibliotecario(Credenciales credenciales) {
        if (credenciales != null) {
            for (Bibliotecario b : bibliotecarios) {
                if (b.getCredenciales().getUsuario().equals(credenciales.getUsuario()) && b.getCredenciales().getContrasena().equals(credenciales.getContrasena())) {
                    return b;
                }
            }
            System.out.println("Credenciales incorrectas.");
        }

        return null;
    }

}
