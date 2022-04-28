package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Supermercado {

    Producto producto = new Producto();

    //Array List de los objetos de org.example.Producto que voy a manejar: listar, borrar, modificar...
    ArrayList<Producto> listaProductos = new ArrayList<>();
    ArrayList<Integer> stockProducto = new ArrayList<>();


    Scanner sc = new Scanner(System.in);
    float caja = 0.0f;

    public Supermercado() {
    }

    public void incrementoStock(ArrayList<Producto> miSupermercado, ArrayList<Integer> stockProducto) {

        Producto producto1 = new Producto(10, 1.7f, "Carne");
        Integer stock1 = new Integer(2);
        Producto producto2 = new Producto(11, 1.6f, "Pescado");
        Integer stock2 = new Integer(12);
        Producto producto3 = new Producto(12, 1.0f, "Verdura");
        Integer stock3 = new Integer(23);

        stockProducto.add(stock1);
        stockProducto.add(stock2);
        stockProducto.add(stock3);

        miSupermercado.add(producto1);
        miSupermercado.add(producto2);
        miSupermercado.add(producto3);

    }

    public int decrementoStock(Integer stock) {
        int s = --stock;
        return s;
    }

    public void incrementoCaja(float precio) {
        caja = caja + precio;
    }

    //llamar aqui oara
    public void listarProductos() {
        //Primero: si la lista esta a 0 , repongo con el metodo
        //Segundo: si hay productos, los muestro
        if (listaProductos.size() == 0) {
            System.out.println("*Lista vacía, vuelve a listar para ver productos de nuevo... ");
            System.out.println("");
            Reponer.reponerProductos(listaProductos, stockProducto);
        } else {
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.println(listaProductos.get(i));
                System.out.println("Stock: " + stockProducto.get(i));
            }
        }
    }

    public void saldoCaja() {

        //Sumar el valor del objeto al de la caja acumulada...Mostrar saldo.
        caja = caja + producto.getPrecio();
        System.out.println("**El saldo de caja es : " + caja + " €");
        System.out.println(" ");
    }

    public void venderProducto(int idaEliminar) {
        //Eliminar del ArrayList el objeto con el id que teclee el usuario
        //ver los id del arrya y comparar?
//        System.out.println("idddd " + listaProductos.get(Integer.parseInt("id")).getId());
//        System.out.println(listaProductos );
//       System.out.println(listaProductos.indexOf(idaEliminar) );
//        System.out.println(listaProductos.contains(idaEliminar));
//        if(listaProductos.indexOf(idaEliminar) >=0){
//            System.out.println("id esta");
//        }else if (listaProductos.indexOf(idaEliminar) <0){
//            System.out.println("id no esta");
//        }

for(Producto p: listaProductos)
{
    System.out.println(p.getId());
    boolean b = p.getId() == idaEliminar;
    System.out.println(b);
    //si esto es true encontre el id??
}


        for (int i = 0; i < listaProductos.size(); i++) {
//            System.out.println(listaProductos.get(i));
//            System.out.println(stockProducto.get(i));

            if (listaProductos.get(i).getId() == idaEliminar) {
                incrementoCaja(listaProductos.get(i).getPrecio());
                //Pongo en la posicion del array Sttock que me encuentro el valor que me duvuelve
                //el metodo de decrementar.
                stockProducto.set(i, decrementoStock(stockProducto.get(i)));
                System.out.println("Vendido !!");
                //sSystem.out.println(stockProducto);
                if (stockProducto.get(i) == 0) {
                    //poner stock a 0 ?
                    listaProductos.remove(i);
                    stockProducto.remove(i);
                }
            } else if (i == listaProductos.size()) {
                System.out.println("ID no existente...");
                System.out.println("");
                //con excepcion
            }
        }

    }


}
