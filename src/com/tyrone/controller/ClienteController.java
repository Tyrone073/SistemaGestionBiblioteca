package com.tyrone.controller;

import com.tyrone.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de clientes en el sistema de biblioteca.
 *
 * Esta clase maneja la lógica de negocio relacionada con el registro y gestión
 * de clientes, incluyendo creación, consulta, modificación y eliminación lógica.
 *
 *
 */
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente El objeto Cliente a registrar
     * @throws IllegalArgumentException Si el objeto cliente es nulo
     */
    public void crearCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
            System.out.println("Cliente creado exitosamente.");
            System.out.println(cliente);
        } else {
            System.out.println("No se pudo crear el cliente.");
        }
    }

    /**
     * Muestra todos los clientes registrados en el sistema.
     *
     * Si no hay clientes registrados, muestra un mensaje informativo.
     *
     */
    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes para mostrar.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    /**
     * Busca un cliente por cédula o nombre.
     *
     * @param algo Cadena que puede contener la cédula (numérica) o nombre del cliente
     * @return El cliente encontrado o null si no se encuentra
     */
    public Cliente buscarCliente(String algo) {
        if (!algo.isEmpty()) {
            // Búsqueda por cédula
            try {
                int cedula = Integer.parseInt(algo);
                for (Cliente c : clientes) {
                    if (c.getCedula() == cedula) {
                        System.out.println("Cliente encontrado");
                        return c;
                    }
                }
            } catch (NumberFormatException e) {
                // Continuar con búsqueda por nombre si no es número
            }

            // Búsqueda por nombre
            for (Cliente c : clientes) {
                if (c.getNombre().equalsIgnoreCase(algo)) {
                    System.out.println("Clientes con nombre: " + algo + " encontrado: ");
                    return c;
                }
            }

            System.out.println("Cliente no encontrado.");
        }
        return null;
    }

    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param id ID del cliente a actualizar
     * @param cliente Objeto Cliente con los nuevos datos
     */
    public void actualizarDatosCliente(Long id, Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                if (cliente.getCedula() != null) {
                    c.setCedula(cliente.getCedula());
                }
                if (cliente.getNombre() != null) {
                    c.setNombre(cliente.getNombre());
                }
                if (cliente.getTelefono() != null) {
                    c.setTelefono(cliente.getTelefono());
                }
                if (cliente.getDireccion() != null) {
                    c.setDireccion(cliente.getDireccion());
                }
                System.out.println("Cliente actualizado exitosamente.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    /**
     * Realiza una eliminación lógica de un cliente (marca como inactivo).
     *
     * @param id ID del cliente a desactivar
     */
    public void eliminarCliente(Long id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                c.setActivo(false);
                System.out.println("Cliente eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
}