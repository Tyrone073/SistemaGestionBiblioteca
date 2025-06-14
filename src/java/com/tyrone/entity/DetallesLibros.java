package java.com.tyrone.entity;

public class DetallesLibros {
    private static long contador = 1;
    private Long id;
    private Libro libro;
    private int cantidad;

    public DetallesLibros() {
    }

    public DetallesLibros(Libro libro, int cantidad) {
        this.id = contador++;
        this.libro = libro;
        this.cantidad = cantidad;
    }
}
