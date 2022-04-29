package clases;

import Excepciones.ListaProductosNegativa;
import Interfaces.IProducto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Interfaces.IReponedor.reponerSupermercado;
import static java.util.stream.Collectors.groupingBy;
import  static java.util.stream.Collectors.*;

public class Supermercado {

    ArrayList<IProducto> productos = new ArrayList<>();
    ArrayList<Integer> stock = new ArrayList<>();
    HashMap<ArrayList<Integer>, ArrayList<IProducto>> mapStockProducto = new HashMap<ArrayList<Integer>, ArrayList<IProducto>>();
    float caja = 0.0f;

    public int incrementoStock(Integer stock) {
        return stock + 5;
    }


    public int decrementoStock(Integer stock) {

        return --stock;

    }

    public void incrementoCaja(float precio) {
        caja = caja + precio;
    }

    public void listarProductos() throws ListaProductosNegativa {
        //Enseño la lista de los productoso
        if (productos.isEmpty()) {
            System.out.println("Lista de productos vacia, rellenando...");
            reponerSupermercado(productos, stock, mapStockProducto);
        } else {


            for (int i = 0; i < productos.size(); i++) {
                System.out.println("Stock => " + stock.get(i) + " --> " + productos.get(i));
            }
        }
    }

    public void mostrarValorCaja() {
        System.out.println("Saldo de caja es : " + caja + " €");
        System.out.println("");
    }

    public void venderProducto(int idaEliminar) {
        if (productos.stream().anyMatch(p -> p.getId() == idaEliminar) == true) {
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).getId() == idaEliminar) {
                    if (stock.get(i) > 0) {
                        System.out.println("Producto Vendido, sumado a caja...");
                        incrementoCaja(productos.get(i).getPrecio());
                        stock.set(i, decrementoStock(stock.get(i)));
                    } else {
                        System.out.println("No se puede vender --> Stock= 0, reponiendo 5 unidades...");
                        stock.set(i, incrementoStock(stock.get(i)));
                    }
                }

            }
        } else {
            System.out.println("Id no existe");
        }
    }
}