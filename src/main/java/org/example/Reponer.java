package org.example;

import interfaces.Reponedor;

import java.util.ArrayList;

public class Reponer implements Reponedor {

    public static void reponerProductos(ArrayList<Producto> miSupermercado, ArrayList<Integer> stockProducto) {

        Supermercado supermercado = new Supermercado();
        supermercado.incrementoStock(miSupermercado , stockProducto);
    }


}
