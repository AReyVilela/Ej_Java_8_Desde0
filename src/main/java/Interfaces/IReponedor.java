package Interfaces;

import Excepciones.NoExisteProducto;
import clases.Producto;
import clases.Supermercado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public interface IReponedor {



    public static void reponerSupermercado(Supermercado supermercado) throws NoExisteProducto {

        ArrayList<IProducto> productos = new ArrayList<>();

        IProducto producto1 = new Producto(1, 2.3f, "Pescado");
        IProducto producto2 = new Producto(2, 1.3f, "Carne");
        IProducto producto3 = new Producto(3, 0.3f, "Verduras");
        IProducto producto4 = new Producto(4, 3.3f, "Pasteles");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);

        supermercado.setProductos(productos);

        supermercado.incrementoStock(1);
        supermercado.incrementoStock(1);
        supermercado.incrementoStock(1);
        supermercado.incrementoStock(2);
        supermercado.incrementoStock(3);
        supermercado.incrementoStock(4);


    }


    public static void reponerCsv(ArrayList<IProducto> productos, ArrayList<Integer> stock) throws IOException {
        //Leo el csv y hago lo mismo que antes
        //Tengo que leer el csv y poner las cosas en su array
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader("/home/arey/Proyectos_Intelli/JavaDesde0/src/main/java/productos.csv"));
            String linea = lector.readLine();

            while (linea != null) {
                //Leo las lineas de csv
//PRIMERA LINEA SALTAR
                //SPLITEAR LOS ELEMENTOS METERLOS METERLOS EN SUS, for para meter los datos.
                //
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
