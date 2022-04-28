package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado();
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        Reponer.reponerProductos(supermercado.listaProductos, supermercado.stockProducto);

        try {
            do {
                menu();
                opcion = Integer.parseInt(sc.nextLine());
                System.out.println("");
                switch (opcion) {
                    case 0: //LISTAR PRODUCTOS
                        supermercado.listarProductos();
                        break;
                    case 1://VENDER PRODUCTO POR ID
                        System.out.println("Indica el ID del producto a vender: ");
                        int idaEliminar = Integer.parseInt(sc.nextLine());
                        supermercado.venderProducto(idaEliminar);
                        break;
                    case 2://MOSTRAR CAJA
                        supermercado.saldoCaja();
                        break;
                    case 3://SALIR
                        System.out.println("SALIENDO");
                        break;
                    default:
                        System.out.println("Opcion no válida ");
                        System.out.println(" ");
                }
            } while (opcion != 3);
        } catch (NumberFormatException e) {
            System.out.println("Error de formato, se pide un número -->  " + e);
        }
        sc.close();

    }//ACABA EL METODO MAIN

    public static void menu() {

        System.out.println("***********Bienvenido al org.example.Supermercado***************");
        System.out.println("0. Listar Productos");
        System.out.println("1. Vender Producto por id");
        System.out.println("2. Mostrar caja");
        System.out.println("3. Salir");
        System.out.println("Elige una opcion: ");
    }

}//FIN DE LA CLASE 'MAIN'