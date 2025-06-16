import com.tyrone.controller.BibliotecarioController;
import com.tyrone.entity.Bibliotecario;
import com.tyrone.entity.Credenciales;
import com.tyrone.entity.Usuario;
import com.tyrone.enums.Cargo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BibliotecarioController controller = new BibliotecarioController();

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("==¡Bienvenido al Sistema Biblioteca==");
        System.out.println("=====================================");
        int opcion = 1;

        do {
            System.out.println("Estás en modo usuario normal");
            System.out.println("\nOpciones disponibles:");
            System.out.println("1. Buscar libros");
            System.out.println("2. Soy trabajador (Iniciar sesión)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");


            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    buscarLibros();
                    break;
                case 2:
                    iniciarSesionTrabajador();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
//                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }while (opcion != 0);

    }

    private static void buscarLibros() {
        System.out.println("\n=== BUSCAR LIBROS ===");
        System.out.print("Ingrese término de búsqueda (título o autor): ");
        String termino = scanner.nextLine();
        controller.clientebuscarLibro(termino);
    }

    private static void iniciarSesionTrabajador() {
        System.out.println("\n=== INICIO DE SESIÓN TRABAJADOR ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        Credenciales credenciales = new Credenciales(usuario, contrasena);
        Bibliotecario bibliotecario = controller.autenticarBibliotecario(credenciales);
        if (bibliotecario != null) {
            mostrarMenuTrabajador(bibliotecario);
        }
    }

    private static void mostrarMenuTrabajador(Bibliotecario bibliotecario) {
       int opcion =1;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("Bienvenido: " + bibliotecario.getNombre() + " (" + bibliotecario.getCargo() + ")");

            // Opciones comunes a todos
            System.out.println("1. Ver mi información");

            // Opciones específicas por rol
            if (bibliotecario.getCargo().equals(Cargo.ADMIN)) {
                System.out.println("2. Gestionar personal");
                System.out.println("3. Gestionar usuarios");
                System.out.println("4. Gestionar libros");
                System.out.println("5. Gestionar prestamos");
                System.out.println("0. Cerrar sesión");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 2:
                        menuGestionarBibliotecario();
                        break;
                    case 3:
                        menuGestionarClientes();
                        break;
                    case 4:
                        menuGestionarLibros();
                        break;
                    case 5:
                        menuGestionarPrestamos();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }

            if (bibliotecario.getCargo().equals(Cargo.RECEPCIONISTA)) {
                System.out.println("2. Registrar préstamos");
                System.out.println("3. Gestionar clientes");
                System.out.println("0. Cerrar sesión");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 2:
                        menuGestionarClientes();
                        break;
                    case 3:
                        menuGestionarPrestamos();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }

            if (bibliotecario.getCargo().equals(Cargo.BODEGUERO)) {
                System.out.println("2. Gestionar libros");
                System.out.println("0. Cerrar sesión");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 2:
                        menuGestionarLibros();
                        break;
                }
            }



            switch (opcion) {
                case 1:
                    controller.buscarBibliotecarioPorId(bibliotecario.getId());
                    break;
                case 0:
                    return; // Salir al menú principal
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 0);
    }

    private static void menuGestionarBibliotecario(){
        System.out.println("===Menu de gestion del personal===");
        System.out.println("1. Registrar bibliotecarios");
        System.out.println("2. Mostrar bibliotecarios");
        System.out.println("3. Buscar bibliotecario por id");
        System.out.println("4. actualizar datos del bibliotecario");
        System.out.println("5. eliminar bibliotecario");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:

                System.out.println("Datos personales del bibliotecario: ");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Cedula: ");
                Integer cedula = scanner.nextInt();
                scanner.nextLine(); // limpia el buffer
                System.out.print("Telefono: ");
                Integer telefono = scanner.nextInt();
                scanner.nextLine(); // limpia el buffer
                System.out.print("Direccion: ");
                String direccion = scanner.nextLine();
                System.out.print("Cargo: ");
                String cargoString = scanner.nextLine().toUpperCase();
                Cargo cargo;
                try {
                    cargo = Cargo.valueOf(cargoString);
                } catch (IllegalArgumentException e) {
                    System.out.println("Cargo no válido. Usando RECEPCIONISTA por defecto.");
                    cargo = Cargo.RECEPCIONISTA;
                }


                System.out.print("Fecha contratacion (dd/MM/yyyy): ");
                String fecha = scanner.nextLine();
                Date fechaContratacion;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    fechaContratacion = sdf.parse(fecha);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha incorrecto. Usando fecha actual.");
                    fechaContratacion = new Date(); // Fecha actual por defecto
                }


                System.out.println("Credenciales del bibliotecario: ");
                System.out.print("Usuario: ");
                String usuario = scanner.nextLine();
                System.out.println("Contraseña: ");
                String contrasena = scanner.nextLine();
                System.out.println("Creando bibliotecario...");
                Usuario datos = new Usuario(nombre, cedula, telefono, direccion);
                Credenciales credenciales = new Credenciales(usuario, contrasena);
                Bibliotecario bibliotecario = new Bibliotecario(datos, credenciales, cargo, fechaContratacion);
                controller.crearBibliotecario(bibliotecario );
                break;
            case 0:
                return; // Salir al menú principal
            default:
                System.out.println("Opción no válida");
        }


    }

    private static void menuGestionarClientes(){
        System.out.println("");
    }

    private static void menuGestionarPrestamos(){
        System.out.println("");
    }

    private static void menuGestionarLibros() {
        System.out.println("");
    }

}