package clases;

import Excepciones.ErrorFormatIntroducido;
import Excepciones.ListaProductosNegativa;
import Interfaces.IProducto;
import Interfaces.IReponedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) throws ErrorFormatIntroducido {

        //Inicializo la opcion del menu y leo el teclado
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        //Creo una instancia de supermercado y llamo a su hasmap apra rellenar
        Supermercado supermercado = new Supermercado();
        IReponedor.reponerSupermercado(supermercado.productos, supermercado.stock, supermercado.mapStockProducto);

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
                    case 3://SALIR
                        System.out.println("SALIENDO...GRACIAS !!");
                        break;
                    default:
                        System.out.println("Opcion no válida ");
                        System.out.println(" ");
                }
            } while (opcion != 3);
        } catch (NumberFormatException e) {
            System.out.println("Error de formato, se pide un número -->  " + e);
        } catch (ListaProductosNegativa e) {
            throw new RuntimeException(e);
        }
        sc.close();

    }//ACABA EL METODO MAIN

    public static void menu() {

        System.out.println("***********Bienvenido al Supermercado***************");
        System.out.println("0. Listar Productos");
        System.out.println("1. Vender Producto por id");
        System.out.println("2. Mostrar caja");
        System.out.println("3. Salir");
        System.out.println("Elige una opcion: ");
    }
}
