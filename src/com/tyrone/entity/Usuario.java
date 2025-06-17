package com.tyrone.entity;

/**
 * Clase que representa a un usuario del sistema de biblioteca.
 * Contiene información básica como nombre, cédula, teléfono y dirección.
 * Es la clase base para Bibliotecario y Cliente.
 */
public class Usuario {
    private static long contador = 1;
    private Long id;
    private String nombre;
    private Integer cedula;
    private Integer telefono;
    private String direccion;
    boolean activo;

    /**
     * Constructor por defecto de Usuario.
     * Crea una instancia vacía de usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor completo de Usuario.
     * @param nombre Nombre completo del usuario
     * @param cedula Número de cédula del usuario
     * @param telefono Número de teléfono del usuario
     * @param direccion Dirección física del usuario
     */
    public Usuario(String nombre, Integer cedula, Integer telefono, String direccion) {
        this.id = contador++;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activo = true;
    }

    /**
     * Obtiene el ID del usuario.
     * @return ID único del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id Nuevo ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre actual del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre Nuevo nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cédula del usuario.
     * @return Número de cédula actual
     */
    public Integer getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del usuario.
     * @param cedula Nuevo número de cédula
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el teléfono del usuario.
     * @return Número de teléfono actual
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     * @param telefono Nuevo número de teléfono
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del usuario.
     * @return Dirección actual del usuario
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     * @param direccion Nueva dirección física
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Verifica si el usuario está activo.
     * @return true si está activo, false si no
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el estado de activación del usuario.
     * @param activo Nuevo estado de activación
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Genera una representación en String del usuario.
     * @return String con todos los datos del usuario
     */
    @Override
    public String toString() {
        return "\nID: " + id +
                "\nNombre: " + nombre +
                "\nCédula: " + cedula +
                "\nTeléfono: " + telefono +
                "\nDirección: " + direccion +
                "\nActivo: " + (activo ? "Sí" : "No");
    }
}
