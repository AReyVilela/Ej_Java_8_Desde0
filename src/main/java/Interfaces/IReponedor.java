package Interfaces;

import clases.Producto;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Map.Entry.comparingByValue;

public interface IReponedor {
    public static void reponerSupermercado(ArrayList<IProducto> productos, ArrayList<Integer> stock,HashMap mapStockProducto){
    //Repongo el supermercado con productos

   //    HashMap<Integer,IProducto> mapStockProducto = new HashMap<>();

        IProducto producto1 = new Producto(1,2.3f,"Pescado");
        IProducto producto2 = new Producto(2,1.3f,"Carne");
        IProducto producto3 = new Producto(3,0.3f,"Verduras");
        IProducto producto4 = new Producto(4,3.3f,"Pasteles");

        Integer stock1= new Integer(1);
        Integer stock2= new Integer(1);
        Integer stock3= new Integer(1);
        Integer stock4= new Integer(1);


        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);

        stock.add(stock1);
        stock.add(stock2);
        stock.add(stock3);
        stock.add(stock4);

        mapStockProducto.put(stock1, (IProducto) producto1);
        mapStockProducto.put(stock2, (IProducto) producto2);
        mapStockProducto.put(stock3, (IProducto) producto3);
        mapStockProducto.put(stock4, (IProducto) producto4);
    //    System.out.println(mapStockProducto);
//
//        //Ordenando el map por numero de stock que tiene
//        mapStockProducto.putAll(mapStockProductoRelleno);
    }
}
