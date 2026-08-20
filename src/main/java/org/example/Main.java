package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

    static Scanner sc= new Scanner(System.in);


    public static void main(String [] args){
        int opcion;

        do {
            System.out.println("\n========= SISTEMA DE BIBLIOTECA =========");
            System.out.println("--- Clientes ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("--- Libros ---");
            System.out.println("6. Registrar libro");
            System.out.println("7. Listar libros");
            System.out.println("8. Buscar libro");
            System.out.println("9. Actualizar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("--- Prestamos ---");
            System.out.println("11. Registrar prestamo");
            System.out.println("12. Devolver libro");
            System.out.println("13. Listar prestamos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación de entrada numérica
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el salto de línea pendiente

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();
                case 6 -> crearLibro();
                case 7 -> listarLibros();
                case 8 -> buscarLibroInteractivo();
                case 9 -> actualizarLibro();
                case 10 -> eliminarLibro();
                case 11 -> crearPrestamo();
                case 12 -> devolverLibro();
                case 13 -> listarPrestamos();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);
        }
    public static void crearCliente(){
        System.out.print("ID: ");
        String id=sc.nextLine();

        System.out.print("Nombre: ");
        String nombre=sc.nextLine();

        System.out.print("Telefono: ");
        String telefono=sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente nuevo=new Cliente(id, nombre, telefono, email);
        clientes.add(nuevo);

        System.out.print("Cliente registrado con exito.");
    }

    public static void listarClientes() {
        System.out.print("=== Lista de clientes ===");

        if (clientes.isEmpty()) {
            System.out.print("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public static Cliente buscarClientePorId(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void buscarCliente() {
        System.out.println("=== Buscar cliente ===");
        System.out.print("Ingrese el ID del cliente a buscar: ");
        String id = sc.nextLine();
        Cliente c = buscarClientePorId(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
        } else {
            System.out.print("Cliente encontrado:");
            System.out.println(c);
        }
    }



    public static void actualizarCliente() {
        System.out.println("=== Actualizar cliente ===");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();
        Cliente c = buscarClientePorId(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Cliente actual: " + c);
        System.out.println("Deje el campo vacío si no desea modificarlo.");
        System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
        String nombre = sc.nextLine();
        if (!nombre.isBlank()) {
            c.setNombre(nombre);
        }

        System.out.print("Nuevo teléfono (" + c.getTelefono() + "): ");
        String telefono = sc.nextLine();
        if (!telefono.isBlank()) {
            c.setTelefono(telefono);
        }

        System.out.print("Nuevo email (" + c.getEmail() + "): ");
        String email = sc.nextLine();
        if (!email.isBlank()) {
            c.setEmail(email);
        }

        System.out.println("Cliente actualizado con éxito.");
        System.out.println("Cliente actualizado: " + c);
    }


    public static void eliminarCliente() {
        System.out.println("=== Eliminar cliente ===");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = sc.nextLine();
        Cliente c = buscarClientePorId(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.println("Cliente encontrado: " + c);
        System.out.print("¿Está seguro de que desea eliminarlo? (S/N): ");
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            clientes.remove(c);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }


    public static void crearLibro() {
        System.out.println("=== Registrar nuevo libro ===");
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicación: ");
        String anioPublic = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        boolean disponible = true;

        Libro nuevo = new Libro(codigo, titulo, anioPublic, autor, disponible);
        libros.add(nuevo);

        System.out.println("Libro registrado con éxito.");
    }



    public static void listarLibros() {
        System.out.println("=== Lista de libros ===");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public static Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    public static void buscarLibroInteractivo() {
        System.out.println("=== Buscar libro ===");

        System.out.print("Ingrese el código del libro a buscar: ");
        String codigo = sc.nextLine();

        Libro l = buscarLibro(codigo);

        if (l == null) {
            System.out.println("Libro no encontrado.");
        } else {
            System.out.println("Libro encontrado:");
            System.out.println(l);
        }
    }



    public static void actualizarLibro() {
        System.out.println("=== Actualizar libro ===");

        System.out.print("Ingrese el código del libro a actualizar: ");
        String codigo = sc.nextLine();

        Libro l = buscarLibro(codigo);

        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.println("Libro actual: " + l);
        System.out.println("Deje el campo vacío si no desea modificarlo.");

        System.out.print("Nuevo título (" + l.getTitulo() + "): ");
        String titulo = sc.nextLine();
        if (!titulo.isBlank()) {
            l.setTitulo(titulo);
        }

        System.out.print("Nuevo año de publicación (" + l.getAnioPublic() + "): ");
        String anioPublic = sc.nextLine();
        if (!anioPublic.isBlank()) {
            l.setAnioPublic(anioPublic);
        }

        System.out.print("Nuevo autor (" + l.getAutor() + "): ");
        String autor = sc.nextLine();
        if (!autor.isBlank()) {
            l.setAutor(autor);
        }

        System.out.println("Libro actualizado con éxito.");
        System.out.println("Libro actualizado: " + l);
    }




    public static void eliminarLibro() {
        System.out.println("=== Eliminar libro ===");

        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = sc.nextLine();

        Libro l = buscarLibro(codigo);

        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.println("Libro encontrado: " + l);
        System.out.print("¿Está seguro de que desea eliminarlo? (S/N): ");
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            libros.remove(l);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    // ================== CREATE (Prestamo) ==================
    public static void crearPrestamo() {
        System.out.println("=== Registrar nuevo préstamo ===");

        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();

        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado. No se puede registrar el préstamo.");
            return;
        }

        System.out.print("Código del libro: ");
        String codigoLibro = sc.nextLine();

        Libro libro = buscarLibro(codigoLibro);

        if (libro == null) {
            System.out.println("Libro no encontrado. No se puede registrar el préstamo.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible actualmente.");
            return;
        }

        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        // La fecha se toma automáticamente del sistema
        LocalDate fecha = LocalDate.now();

        String estado = "Activo";

        Prestamo nuevo = new Prestamo(idPrestamo, cliente, libro, fecha, estado);
        prestamos.add(nuevo);

        // Al prestar el libro, ya no está disponible
        libro.setDisponible(false);

        System.out.println("Préstamo registrado con éxito.");
        System.out.println(nuevo);
    }




    public static void devolverLibro() {
        System.out.println("=== Registrar devolución ===");

        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        Prestamo prestamo = buscarPrestamoPorId(idPrestamo);

        if (prestamo == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        if (prestamo.getEstado().equalsIgnoreCase("Devuelto")) {
            System.out.println("Este préstamo ya fue devuelto anteriormente.");
            return;
        }

        prestamo.setEstado("Devuelto");

        prestamo.getLibro().setDisponible(true);

        System.out.println("Devolución registrada con éxito.");
        System.out.println(prestamo);
    }

    public static Prestamo buscarPrestamoPorId(String idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo)) {
                return p;
            }
        }
        return null; // No encontrado
    }


    // ================== READ (listar prestamos) ==================
    public static void listarPrestamos() {
        System.out.println("=== Lista de préstamos ===");

        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}
