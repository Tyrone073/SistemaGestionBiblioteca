package com.tyrone.entity;

import com.tyrone.enums.Cargo;
import java.util.Date;

/**
 * Representa un bibliotecario en el sistema de biblioteca.
 *
 * Extiende la clase Usuario agregando credenciales de acceso,
 * cargo administrativo y fecha de contratación.
 *
 *
 */
public class Bibliotecario extends Usuario {
    private Credenciales credenciales;
    private Cargo cargo;
    private Date fechaContratacion;

    /**
     * Constructor por defecto.
     */
    public Bibliotecario() {
    }

    /**
     * Constructor completo para crear un bibliotecario.
     *
     * @param usuario Datos personales heredados de Usuario
     * @param credenciales Credenciales de acceso al sistema
     * @param cargo Rol/posición del bibliotecario (enum Cargo)
     * @param fechaContratacion Fecha cuando fue contratado
     */
    public Bibliotecario(Usuario usuario, Credenciales credenciales, Cargo cargo, Date fechaContratacion) {
        super(usuario.getNombre(), usuario.getCedula(), usuario.getTelefono(), usuario.getDireccion());
        this.credenciales = credenciales;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Obtiene las credenciales de acceso del bibliotecario.
     * @return Objeto Credenciales
     */
    public Credenciales getCredenciales() {
        return credenciales;
    }

    /**
     * Establece las credenciales de acceso.
     * @param credenciales Nuevas credenciales
     */
    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    /**
     * Obtiene el cargo del bibliotecario.
     * @return Enumeración Cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del bibliotecario.
     * @param cargo Nuevo cargo (enum Cargo)
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtiene la fecha de contratación.
     * @return Fecha de contratación
     */
    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Establece la fecha de contratación.
     * @param fechaContratacion Nueva fecha de contratación
     */
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Representación en String del bibliotecario.
     * @return String con todos los datos del bibliotecario
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nCredenciales: " + credenciales +
                "\nCargo: " + cargo +
                "\nFecha de Contratación: " + fechaContratacion;
    }
}