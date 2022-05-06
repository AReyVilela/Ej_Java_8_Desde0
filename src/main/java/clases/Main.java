package clases;

import Excepciones.ListaProductosNegativa;
import Excepciones.NoExisteProducto;
import Interfaces.IReponedor;

import java.util.Scanner;

//RAMA DEL MAINNN MERGEADA CON LA RAMA FINAL

public class Main {
    public static void main(String[] args) throws   NoExisteProducto {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        Supermercado supermercado = new Supermercado();
        IReponedor.reponerSupermercado(supermercado);

        //LLAMO A REPONER LA PRIMERA VEZ CON EL CSV
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
                        System.out.println("Indique el ID del producto a vender: ");
                        int idaEliminar = Integer.parseInt(sc.nextLine());
                        supermercado.venderProducto(idaEliminar);
                        break;
                    case 2://MOSTRAR CAJA
                        supermercado.mostrarValorCaja();
                        break;
                    case 3:
                        //filtrar por stock
                        System.out.println("Indique el stock maximo: ");
                        int stockFilter = Integer.parseInt(sc.nextLine());
                        supermercado.filtrarProductosporStock(stockFilter);
                        break;
                    case 4:
                        //ordenados por precio
                        supermercado.ordenarPorPrecio();
                        break;
                    case 5:
                        //ordenados por stock
                        supermercado.ordendarPorStock();
                        break;
                    case 6://SALIR
                        System.out.println("SALIENDO...GRACIAS !!");
                        break;
                    default:
                        System.out.println("Opcion no válida ");
                        System.out.println(" ");
                }
            } while (opcion != 6);
        } catch (NumberFormatException e) {
            System.out.println("Error de formato, se pide un número -->  " + e);
        } catch (ListaProductosNegativa e) {
            throw new RuntimeException(e);
        } catch (NoExisteProducto e) {
            throw new RuntimeException(e);
        }
        sc.close();

    }//ACABA EL METODO MAIN

    public static void menu() {

        System.out.println("***********Bienvenido al Supermercado***************");
        System.out.println("0. Listar Productos");
        System.out.println("1. Vender Producto por id");
        System.out.println("2. Mostrar caja");
        System.out.println("3. Listar productos con stock menor a X ");
        System.out.println("4. Listar productos ordenados por precio");
        System.out.println("5. Listar productos ordenados por stock");
        System.out.println("6. Salir");
        System.out.println("Elige una opcion: ");
    }
}
