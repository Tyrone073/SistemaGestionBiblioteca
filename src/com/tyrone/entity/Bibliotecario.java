package com.tyrone.entity;

import com.tyrone.enums.Cargo;
import java.util.Date;

public class Bibliotecario extends Usuario {
    private Credenciales credenciales;
    private Cargo cargo;
    private Date fechaContratacion;

    public Bibliotecario() {
    }

    public Bibliotecario(Usuario usuario, Credenciales credenciales, Cargo cargo, Date fechaContratacion) {
        super(usuario.getNombre(), usuario.getCedula(), usuario.getTelefono(), usuario.getDireccion());
        this.credenciales = credenciales;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
    }
    public Credenciales getCredenciales() {
        return credenciales;
    }
    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Date getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nCredenciales: " + credenciales +
               "\ncargo: " + cargo +
               ",\nFecha de Contratacion: " + fechaContratacion;
    }
}
