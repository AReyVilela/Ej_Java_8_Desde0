import java.util.ArrayList;

public interface Reponedor {

    public static void ReponerProductos(ArrayList<Producto> Misupermercado, ArrayList<Integer> stockProducto) {
        Producto producto1 = new Producto(10, 1.7f, "des");
        Integer stock1 = new Integer(2);
        Producto producto2 = new Producto(11, 1.6f, "des");
        Integer stock2 = new Integer(12);
        Producto producto3 = new Producto(12, 1.0f, "des");
        Integer stock3 = new Integer(23);

        stockProducto.add(stock1);
        stockProducto.add(stock2);
        stockProducto.add(stock3);
        Misupermercado.add(producto1);
        Misupermercado.add(producto2);
        Misupermercado.add(producto3);


    }

}
