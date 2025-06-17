package com.tyrone.entity;

/**
 * Representa las credenciales de acceso para un usuario del sistema.
 *
 * Contiene información de autenticación como nombre de usuario y contraseña.
 * Cada instancia tiene un ID único generado automáticamente.
 */
public class Credenciales {
    private static long contador = 1;
    private Long id;
    private String usuario;
    private String contrasena;

    /**
     * Constructor por defecto que crea credenciales vacías.
     */
    public Credenciales() {
    }

    /**
     * Constructor que inicializa las credenciales con usuario y contraseña.
     *
     * @param usuario Nombre de usuario para autenticación
     * @param contrasena Contraseña para autenticación
     */
    public Credenciales(String usuario, String contrasena) {
        this.id = contador++;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el ID único de las credenciales.
     * @return El ID de las credenciales
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de las credenciales.
     * @param id El nuevo ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario actual
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece un nuevo nombre de usuario.
     * @param usuario El nuevo nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña actual.
     * @return La contraseña almacenada
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece una nueva contraseña.
     * @param contrasena La nueva contraseña a almacenar
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Representación en String de las credenciales.
     * @return String con los datos de usuario y contraseña
     */
    @Override
    public String toString() {
        return "\nusuario: " + usuario +
                "\ncontrasena: " + contrasena;
    }
}