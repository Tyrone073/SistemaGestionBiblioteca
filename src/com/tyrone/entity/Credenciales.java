package com.tyrone.entity;

public class Credenciales {
    private static long contador = 1;
    private Long id;
    private String usuario;
    private String contrasena;

    public Credenciales() {
    }

    public Credenciales(String usuario, String contrasena) {
        this.id = contador++;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
