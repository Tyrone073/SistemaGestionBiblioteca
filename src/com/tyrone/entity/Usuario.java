package com.tyrone.entity;

public class Usuario {
    private static long contador = 1;
    private Long id;
    private String nombre;
    private Integer cedula;
    private Integer telefono;
    private String direccion;
    boolean activo;

    public Usuario() {
    }

    public Usuario(String nombre, Integer cedula, Integer telefono, String direccion) {
        this.id = contador++;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activo = true;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCedula() {
        return cedula;
    }
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

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
