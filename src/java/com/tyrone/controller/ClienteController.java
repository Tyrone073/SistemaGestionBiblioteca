package java.com.tyrone.controller;

import java.com.tyrone.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    public void crearCliente(Cliente cliente){
        if (cliente != null){
            clientes.add(cliente);
            System.out.println("Cliente creado exitosamente.");
            System.out.println( cliente);
        }else {
            System.out.println("No se pudo crear el cliente.");
        }
    }

    public void mostrarClientes(){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes para mostrar.");
        }else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public void buscarCliente(String algo){
        if (!algo.isEmpty()){
            try {
                for (Cliente c : clientes) {
                    if (c.getCedula() == Integer.parseInt(algo)) {
                        System.out.println("Cliente encontrado: " + c);
                        return;
                    }
                }
            }catch (NumberFormatException _){
            }
            try {
                for (Cliente c : clientes) {
                    if (c.getNombre().equals(algo)) {
                        System.out.println("Clientes con nombre: " + algo + " : " + c);
                        return;
                    }
                }
            }catch (RuntimeException e){
                System.out.println("Cliente o nombre inexistentes");
            }
        }
    }

    public void actualizarDatosCliente(Long id, Cliente cliente){
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                if (cliente.getCedula() != null) {
                    c.setCedula(cliente.getCedula());
                }
                if (c.getNombre() != null) {
                    c.setNombre(cliente.getNombre());
                }
                if (c.getTelefono() != null) {
                    c.setTelefono(cliente.getTelefono());
                }
                if (c.getDireccion() != null) {
                    c.setDireccion(cliente.getDireccion());
                }
                System.out.println("Cliente actualizado exitosamente.");
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void eliminarCliente(Long id){
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
//                clientes.remove(c);
                c.setActivo(false);
                System.out.println("Cliente eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
}
