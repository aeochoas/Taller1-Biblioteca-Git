package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);


    public static void main(String [] args){
        //menu
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
}
