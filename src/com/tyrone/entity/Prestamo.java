package com.tyrone.entity;

import com.tyrone.enums.Estado;
import java.util.Date;
import java.util.List;

public class Prestamo {
    private static long contador = 1;
    private Long id;
    private List<DetallesLibros> detallesLibros;
    private Cliente cliente;
    private Bibliotecario recepcionista;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Estado estado;

    public Prestamo() {
    }

    public Prestamo(List<DetallesLibros> detallesLibros, Cliente cliente, Bibliotecario recepcionista, Date fechaPrestamo, Date fechaDevolucion, Estado estado) {
        this.id = contador++;
        this.detallesLibros = detallesLibros;
        this.cliente = cliente;
        this.recepcionista = recepcionista;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<DetallesLibros> getDetallesLibros() {
        return detallesLibros;
    }
    public void setDetallesLibros(List<DetallesLibros> detallesLibros) {
        this.detallesLibros = detallesLibros;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Bibliotecario getRecepcionista() {
        return recepcionista;
    }
    public void setRecepcionista(Bibliotecario recepcionista) {
        this.recepcionista = recepcionista;
    }
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nid=" + id +
               "\ndetallesLibros=" + detallesLibros +
               "\ncliente=" + cliente +
               "\nrecepcionista=" + recepcionista +
               "\nfechaPrestamo=" + fechaPrestamo +
               "\nfechaDevolucion=" + fechaDevolucion +
               "\nestado=" + estado;

    }
}
