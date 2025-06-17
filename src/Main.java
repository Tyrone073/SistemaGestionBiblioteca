import com.tyrone.controller.BibliotecarioController;
import com.tyrone.entity.*;
import com.tyrone.enums.Cargo;
import com.tyrone.enums.Estado;
import com.tyrone.enums.Genero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BibliotecarioController controller = new BibliotecarioController();
    static Long id;

    static {
        Usuario datos = new Usuario("Tyrone", 1234567890, 999999999, "Av. Central");
        Credenciales cred = new Credenciales("admin", "1234");
        Bibliotecario admin = new Bibliotecario(datos, cred, Cargo.ADMIN, new Date());
        controller.crearBibliotecario(admin);

        Usuario datos1 = new Usuario("Juan", 12342390, 999999999, "Av. C1");
        Credenciales cred1 = new Credenciales("juan", "12345");
        Bibliotecario admin1 = new Bibliotecario(datos, cred, Cargo.RECEPCIONISTA, new Date());
        controller.crearBibliotecario(admin1);

        Usuario datos2 = new Usuario("Pedro", 1234567890, 999999999, "Av. j2");
        Credenciales cred2 = new Credenciales("pedro", "123");
        Bibliotecario admin2 = new Bibliotecario(datos, cred, Cargo.BODEGUERO, new Date());
        controller.crearBibliotecario(admin2);

        Usuario datos3 = new Usuario("Maria", 1302234644, 999999999, "Av. j3");
        Cliente cliente = new Cliente(datos3);
        controller.registrarCliente(cliente);

        Usuario datos4 = new Usuario("Jose", 1234567890, 999999999, "Av. j4");
        Cliente cliente1 = new Cliente(datos4);
        controller.registrarCliente(cliente1);

        Libro libro = new Libro("Dune", "Frank Herbert", Genero.CIENCIA_FICCION, 15, "Pasillo C1, Repisa 4b, casilla 8");
        controller.registrarLibro(libro);
    }

    public static void main(String[] args) {

        int opcion = 1;

        System.out.println("=====================================");
        System.out.println("==¡Bienvenido al Sistema Biblioteca==");
        System.out.println("=====================================");



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
        Libro libro = controller.buscarLibro(termino);
        System.out.println(libro);
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
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("Bienvenido: " + bibliotecario.getNombre() + " (" + bibliotecario.getCargo() + ")");

            // Opciones comunes a todos
            System.out.println("1. Ver mi información");

            // Opciones específicas por rol
            if (bibliotecario.getCargo().equals(Cargo.ADMIN)) {
                System.out.println("2. Gestionar personal");
                System.out.println("3. Gestionar clientes");
                System.out.println("4. Gestionar libros");
                System.out.println("5. Gestionar prestamos");
            } else if (bibliotecario.getCargo().equals(Cargo.RECEPCIONISTA)) {
                System.out.println("2. Registrar préstamos");
                System.out.println("3. Gestionar clientes");
            } else if (bibliotecario.getCargo().equals(Cargo.BODEGUERO)) {
                System.out.println("2. Gestionar libros");
            }

            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println(controller.buscarBibliotecarioPorId(bibliotecario.getId()));
                    break;
                case 2:
                    if (bibliotecario.getCargo().equals(Cargo.ADMIN)) {
                        menuGestionarPersonal();
                    } else if (bibliotecario.getCargo().equals(Cargo.RECEPCIONISTA)) {
                        menuGestionarPrestamos(bibliotecario);
                    } else if (bibliotecario.getCargo().equals(Cargo.BODEGUERO)) {
                        menuGestionarLibros();
                    }
                    break;
                case 3:
                    if (bibliotecario.getCargo().equals(Cargo.ADMIN) || bibliotecario.getCargo().equals(Cargo.RECEPCIONISTA)) {
                        menuGestionarClientes();
                    }
                    break;
                case 4:
                    if (bibliotecario.getCargo().equals(Cargo.ADMIN)) {
                        menuGestionarLibros();
                    }
                    break;
                case 5:
                    if (bibliotecario.getCargo().equals(Cargo.ADMIN)) {
                        menuGestionarPrestamos(bibliotecario);
                    }
                    break;
                case 0:
                    return; // Esto ahora retornará correctamente al menú principal
                default:
                    System.out.println("Opción no válida");
            }
        } while (true);
    }

    private static void menuGestionarPersonal(){
        int opcion;

        System.out.println("\n===Menu de gestion del personal===");
        System.out.println("1. Registrar bibliotecarios");
        System.out.println("2. Mostrar bibliotecarios");
        System.out.println("3. Buscar bibliotecario por id");
        System.out.println("4. actualizar datos del bibliotecario");
        System.out.println("5. eliminar bibliotecario");
        System.out.println("0. volver");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:
                System.out.println("Todos los datos son obligatorios:");
                Bibliotecario nuevosDatos = PedirDatosBibliotecario();
                controller.crearBibliotecario(nuevosDatos);
                break;
            case 2:
                System.out.println("Mostrando bibliotecarios...");
                controller.mostrarBibliotecarios();
                break;
            case 3:
                System.out.println("Ingrese el id del bibliotecario a buscar: ");
                id = scanner.nextLong();
                scanner.nextLine();
                Bibliotecario bibliotecario = controller.buscarBibliotecarioPorId(id);
                System.out.println(bibliotecario);
                break;
            case 4:
                System.out.println("Ingrese el id del bibliotecario a actualizar: ");
                id = scanner.nextLong();
                scanner.nextLine();
                Bibliotecario existe = controller.buscarBibliotecarioPorId(id);
                if (existe != null){
                    System.out.println("bibliotecario encontrado: " + existe.getNombre() + " (" + existe.getCargo() + ")");
                    System.out.println("Escriba Los datos que desea actualizar, dejando en blanco los que no se deseen cambiar: ");
                    Bibliotecario nuevosDatos1 = PedirDatosBibliotecario();
                    controller.actualizarDatosBibliotecario(id, nuevosDatos1);
                }
                break;
            case 5:
                System.out.println("Ingrese el id del bibliotecario a eliminar: ");
                id = scanner.nextLong();
                scanner.nextLine();
                controller.eliminarBibliotecario(id);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida");
        }


    }

    private static Bibliotecario PedirDatosBibliotecario(){
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
        System.out.println("Registrando datos del bibliotecario...");
        Usuario datos = new Usuario(nombre, cedula, telefono, direccion);
        Credenciales credenciales = new Credenciales(usuario, contrasena);
        Bibliotecario bibliotecario = new Bibliotecario(datos, credenciales, cargo, fechaContratacion);
        return bibliotecario;
    }

    private static void menuGestionarClientes(){
        int opcion;

        System.out.println("\n===Menu de gestion de clientes===");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Mostrar clientes");
        System.out.println("3. Buscar cliente por nombre o cedula");
        System.out.println("4. actualizar datos del cliente");
        System.out.println("5. eliminar cliente");
        System.out.println("0. volver");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:
                System.out.println("Todos los datos son obligatorios:");
                Cliente nuevosDatos = PedirDatosCliente();
                controller.registrarCliente(nuevosDatos);
                break;
            case 2:
                System.out.println("Mostrando clientes...");
                controller.mostrarClientes();
                break;
            case 3:
                System.out.println("Escriba el nombre o cedula del cliente a buscar: ");
                String mensaje = scanner.nextLine();
                Cliente cliente = controller.buscarCliente(mensaje);
                System.out.println(cliente);
                break;
            case 4:
                System.out.println("Ingrese el nombre o cedula del cliente que desee actualizar datos: ");
                String mensje = scanner.nextLine();
                Cliente existe = controller.buscarCliente(mensje);
                if (existe != null){
                    System.out.println("Cliente encontrado: " + existe.getNombre() + " (" + existe.getCedula() + ")");
                    System.out.println("Escriba Los datos que desea actualizar, dejando en blanco los que no se deseen cambiar: ");
                    Cliente nuevosDatos1 = PedirDatosCliente();
                    controller.actualizarDatosCliente(existe.getId(), nuevosDatos1);
                }
            case 5:
                System.out.println("Ingrese el nombre o cedula del cliente que desee eliminar: ");
                String mensaje2 = scanner.nextLine();
                Cliente existe2 = controller.buscarCliente(mensaje2);
                if (existe2 != null){
                    System.out.println("Cliente : " + existe2.getNombre() + " (" + existe2.getCedula() + ") eliminado exitosamente.");
                    controller.eliminarCliente(existe2.getId());
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida");

        }
    }

    private static Cliente PedirDatosCliente(){
        System.out.println("Datos personales del Cliente: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        // Validación de cédula
        int cedula;
        while (true) {
            try {
                System.out.print("Cedula: ");
                cedula = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese solo números y numeros de 10 digitos para la cédula");
            }
        }

        // Validación de teléfono
        int telefono;
        while (true) {
            try {
                System.out.print("Telefono: ");
                telefono = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese solo números y numeros de 10 digitos para el teléfono");
            }
        }
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        System.out.println("Registrando datos del cliente...");
        Usuario datos = new Usuario(nombre, cedula, telefono, direccion);
        Cliente cliente = new Cliente(datos);
        return cliente;
    }

    private static void menuGestionarLibros() {
        int opcion;

        System.out.println("\n===Menu de gestion de libros===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Mostrar libros");
        System.out.println("3. Buscar libro por titulo o autor");
        System.out.println("4. actualizar datos del libro");
        System.out.println("5. eliminar libro");
        System.out.println("0. volver");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:
                System.out.println("Todos los datos son obligatorios:");
                Libro nuevosDatos = PedirDatosLibro();
                controller.registrarLibro(nuevosDatos);
                break;
            case 2:
                System.out.println("Mostrando libros...");
                controller.mostrarLibros();
                break;
            case 3:
                buscarLibros();
                break;
            case 4:
                System.out.println("Ingrese el titulo o autor del libro que desee actualizar datos: ");
                String mensaje = scanner.nextLine();
                Libro libro = controller.buscarLibro(mensaje);
                if (libro != null){
                    System.out.println("Libro encontrado: " + libro.getTitulo() + " (" + libro.getAutor() + ")");
                    System.out.println("Escriba Los datos que desea actualizar, dejando en blanco los que no se deseen cambiar: ");
                    Libro nuevosDatos1 = PedirDatosLibro();
                    controller.actualizarDatosLibro(libro.getId(), nuevosDatos1);
                }
                break;
                case 5:
                System.out.println("Ingrese el titulo o autor del libro que desee eliminar: ");
                String mensaje2 = scanner.nextLine();
                Libro libro2 = controller.buscarLibro(mensaje2);
                if (libro2 != null){
                    System.out.println("Libro : " + libro2.getTitulo() + " (" + libro2.getAutor() + ") eliminado exitosamente.");
                    controller.eliminarLibro(libro2.getId());
                }
        }
    }

    private static Libro PedirDatosLibro(){
        System.out.println("Datos del libro: ");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Genero: ");
        String generoString = scanner.nextLine().toUpperCase();
        Genero genero;
        try {
            genero = Genero.valueOf(generoString);
        } catch (IllegalArgumentException e) {
            System.out.println("Cargo no válido. Usando el genero NOVELA por defecto.");
            genero = Genero.NOVELA;
        }

        int ejemplares;
        while (true) {
            try {
                System.out.print("Cantidad de ejemplares: ");
                ejemplares = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese solo números");
            }
        }
        System.out.print("Está archivado en: ");
        String ubicacion = scanner.nextLine();

        System.out.println("Registrando datos del libro...");
        Libro libro = new Libro(titulo, autor, genero, ejemplares, ubicacion);
        return libro;
    }

    private static void menuGestionarPrestamos(Bibliotecario recepcionista) {
        int opcion;

        System.out.println("===Menu de gestion de prestamos===");
        System.out.println("1. Registrar prestamo");
        System.out.println("2. Mostrar prestamos activos");
        System.out.println("3. Mostrar todos los prestamos");
        System.out.println("4. buscar prestamo por id, cedula o fecha de prestamo");
        System.out.println("5. actualizar datos del prestamo");
        System.out.println("6. finalizar prestamo");
        System.out.println("7. eliminar prestamo");
        System.out.println("0. volver");
        opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:
                System.out.println("Todos los datos son obligatorios:");
                Prestamo nuevosDatos = PedirDatosPrestamo(recepcionista);
                controller.registrarPrestamolibro(nuevosDatos);
                break;
            case 2:
                System.out.println("Prestamos activos...");
                controller.mostrarPrestamosActivosLibros();
                break;
            case 3:
                System.out.println("Todos los prestamos...");
                controller.mostrarTodosLosPrestamosLibros();
                break;
            case 4:
                System.out.println("Ingrese el id, cedula o fecha del prestamo a buscar: ");
                String mensaje = scanner.nextLine();
                Prestamo prestamo = controller.buscarPrestamo(mensaje);
                System.out.println(prestamo);
            case 5:
                System.out.println("Ingrese el id, cedula o fecha del prestamo a actualizar: ");
                String mensje = scanner.nextLine();
                Prestamo prestamoEncontrado = controller.buscarPrestamo(mensje);
                if (prestamoEncontrado != null){
                    System.out.println("Prestamo encontrado: " + prestamoEncontrado.getCliente() + " (" + prestamoEncontrado.getDetallesLibros() + ")");
                    System.out.println("Escriba Los datos que desea actualizar, dejando en blanco los que no se deseen cambiar: ");
                    Prestamo nuevosDatos1 = PedirDatosPrestamo(recepcionista);
                    controller.modificarPrestamo(prestamoEncontrado.getId(), nuevosDatos1);
                }
                break;
            case 6:
                System.out.println("Ingrese el id, cedula o fecha del prestamo a finalizar: ");
                String mensje2 = scanner.nextLine();
                Prestamo prestamoEncontrado2 = controller.buscarPrestamo(mensje2);
                if (prestamoEncontrado2 != null){
                    System.out.println("Prestamo encontrado: " + prestamoEncontrado2.getCliente() + " (" + prestamoEncontrado2.getDetallesLibros() + ")");
                    controller.finalizarPrestamo(prestamoEncontrado2.getId());
                }
                break;
            case 7:
                System.out.println("Ingrese el id, cedula o fecha del prestamo a eliminar: ");
                String mensje3 = scanner.nextLine();
                Prestamo prestamoEncontrado3 = controller.buscarPrestamo(mensje3);
                if (prestamoEncontrado3 != null){
                    System.out.println("Prestamo : " + prestamoEncontrado3.getCliente() + " (" + prestamoEncontrado3.getDetallesLibros() + ") eliminado exitosamente.");
                    controller.eliminarPrestamo(prestamoEncontrado3.getId());
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida");
        }


    }

    private static Prestamo PedirDatosPrestamo (Bibliotecario recepcionista){
        System.out.println("Datos del prestamo: ");
        List<DetallesLibros> detallesLibros = new ArrayList<>();
        while (true) {
            System.out.print("Libro: ");
            String libro = scanner.nextLine();
            Libro libroEncontrado = controller.buscarLibro(libro);
            if (libroEncontrado != null) {
                System.out.print("Cantidad de ejemplares: ");
                Integer cantidad = scanner.nextInt();
                scanner.nextLine();
                detallesLibros.add(new DetallesLibros(libroEncontrado, cantidad));
                System.out.print("¿Desea agregar otro libro? (s/n): ");
                String respuesta = scanner.nextLine().toUpperCase();
                if (!respuesta.equals("S")) {
                    break;
                }
            }
            System.out.print("¿Desea volver? (s/n): ");
            String respuesta1 = scanner.nextLine().toUpperCase();
            if (respuesta1.equals("S")) {
                break;
            }

        }

        System.out.print("Cliente: ");
        String cliente = scanner.nextLine();
        Cliente clienteencontrado = controller.buscarCliente(cliente);

        Date fechaInicio = new Date();// Fecha actual por defecto

        Date fechaFin;
        while (true) {
            System.out.print("Fecha de devolucion (dd/MM/yyyy): ");
            String fechaF = scanner.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false); // Esto evita fechas como 32/02/2025
                fechaFin = sdf.parse(fechaF);
                break; // Salir del bucle si la fecha fue válida
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
            }
        }

        System.out.println("Registrando datos del prestamo...");
        Prestamo prestamo = new Prestamo(detallesLibros, clienteencontrado, recepcionista, fechaInicio, fechaFin, Estado.ACTIVO);
        return prestamo;
    }
}