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
        System.out.println("ID: ");
        String id=sc.nextLine();

        System.out.println("Nombre: ");
        String nombre=sc.nextLine();

        System.out.println("Telefono: ");
        String telefono=sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        Cliente nuevo=new Cliente(id, nombre, telefono, email);
        clientes.add(nuevo);

        System.out.println("Cliente registrado con exito.");
    }
}
