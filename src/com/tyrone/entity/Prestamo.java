package com.tyrone.entity;

import com.tyrone.enums.Estado;
import java.util.Date;
import java.util.List;

/**
 * Representa un préstamo de libros en el sistema de biblioteca.
 * Contiene información sobre los libros prestados, cliente, fechas y estado del préstamo.
 */
public class Prestamo {
    private static long contador = 1;
    private Long id;
    private List<DetallesLibros> detallesLibros;
    private Cliente cliente;
    private Bibliotecario recepcionista;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Estado estado;

    /**
     * Constructor por defecto que crea un préstamo vacío.
     */
    public Prestamo() {
    }

    /**
     * Constructor que inicializa un préstamo con todos sus datos.
     * @param detallesLibros Lista de libros prestados con sus cantidades
     * @param cliente Cliente que realiza el préstamo
     * @param recepcionista Bibliotecario que registra el préstamo
     * @param fechaPrestamo Fecha en que se realiza el préstamo
     * @param fechaDevolucion Fecha límite de devolución
     * @param estado Estado actual del préstamo (ACTIVO, FINALIZADO, etc.)
     */
    public Prestamo(List<DetallesLibros> detallesLibros, Cliente cliente, Bibliotecario recepcionista,
                    Date fechaPrestamo, Date fechaDevolucion, Estado estado) {
        this.id = contador++;
        this.detallesLibros = detallesLibros;
        this.cliente = cliente;
        this.recepcionista = recepcionista;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    /**
     * Obtiene el ID único del préstamo.
     * @return El ID del préstamo
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del préstamo.
     * @param id El nuevo ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la lista de detalles de libros prestados.
     * @return Lista de DetallesLibros
     */
    public List<DetallesLibros> getDetallesLibros() {
        return detallesLibros;
    }

    /**
     * Establece la lista de detalles de libros prestados.
     * @param detallesLibros Nueva lista de DetallesLibros
     */
    public void setDetallesLibros(List<DetallesLibros> detallesLibros) {
        this.detallesLibros = detallesLibros;
    }

    /**
     * Obtiene el cliente asociado al préstamo.
     * @return El Cliente del préstamo
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al préstamo.
     * @param cliente Nuevo Cliente a asignar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el bibliotecario que registró el préstamo.
     * @return El Bibliotecario recepcionista
     */
    public Bibliotecario getRecepcionista() {
        return recepcionista;
    }

    /**
     * Establece el bibliotecario que registra el préstamo.
     * @param recepcionista Nuevo Bibliotecario a asignar
     */
    public void setRecepcionista(Bibliotecario recepcionista) {
        this.recepcionista = recepcionista;
    }

    /**
     * Obtiene la fecha en que se realizó el préstamo.
     * @return Fecha de préstamo
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Establece la fecha en que se realizó el préstamo.
     * @param fechaPrestamo Nueva fecha de préstamo
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Obtiene la fecha límite de devolución.
     * @return Fecha de devolución
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece la fecha límite de devolución.
     * @param fechaDevolucion Nueva fecha de devolución
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Obtiene el estado actual del préstamo.
     * @return Estado del préstamo
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado del préstamo.
     * @param estado Nuevo estado del préstamo
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Representación en String de la información del préstamo.
     * @return String con ID, detalles de libros, cliente, recepcionista y fechas
     */
    @Override
    public String toString() {
        return "\nid: " + id +
                "\ndetallesLibros: " + detallesLibros +
                "\ncliente: " + cliente.getNombre() + " " + cliente.getCedula() +
                "\nrecepcionista: " + recepcionista.getNombre() +
                "\nfechaPrestamo: " + fechaPrestamo +
                "\nfechaDevolucion: " + fechaDevolucion +
                "\nestado: " + estado;
    }
}