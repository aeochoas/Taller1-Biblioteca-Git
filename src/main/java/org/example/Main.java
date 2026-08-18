package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
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
}
