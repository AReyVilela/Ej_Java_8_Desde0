import com.sun.xml.internal.ws.spi.db.BindingContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Supermercado {

    Producto producto = new Producto();
    //Array List de los objetos de Producto que voy a manejar: listar, borrar, modificar...
    ArrayList<Producto> ListaProductos = new ArrayList<>();
    ArrayList<Integer> StockProducto = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    float caja = 0.0f;
    int stockNuevo;

    public Supermercado() {
    }

    public int IncrementoStock(Integer stock) {
        int s = ++stock;
        return s;
    }

    public int DecrementoStock(Integer stock) {

        int s = --stock;
        return s;
    }

    public void IncrementoCaja(float precio) {
        caja = caja + precio;
    }

    public void ListarProductos() {
        //Primero: si la lista esta a 0 , repongo con el metodo
        //Segundo: si hay productos, los muestro
        if (ListaProductos.size() == 0) {
            System.out.println("*Lista vacía, vuelve a listar para ver productos de nuevo... ");
            System.out.println("");
            Reponedor.ReponerProductos(ListaProductos, StockProducto);
        } else {
            for (int i = 0; i < ListaProductos.size(); i++) {
                System.out.println(ListaProductos.get(i));
                System.out.println("Stock: " + StockProducto.get(i));
            }
        }
    }

    public void SaldoCaja() {

        //Sumar el valor del objeto al de la caja acumulada...Mostrar saldo.
        caja = caja + producto.getPrecio();
        System.out.println("**El saldo de caja es : " + caja + " €");
        System.out.println(" ");
    }

    public void VenderProducto() {
        //Eliminar del ArrayList el objeto con el id que teclee el usuario

        System.out.println("Indica el ID del producto a eliminar: ");
        int idaEliminar = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < ListaProductos.size(); i++) {
//            System.out.println(ListaProductos.get(i));
//            System.out.println(StockProducto.get(i));

            if (ListaProductos.get(i).getId() == idaEliminar) {
                IncrementoCaja(ListaProductos.get(i).getPrecio());
                int x = DecrementoStock(StockProducto.get(i));
                //Pongo en la posicion del array Sttock que me encuentro el valor que me duvuelve
                //el metodo de decrementar.
                StockProducto.set(i,x);
                //sSystem.out.println(StockProducto);
                if (StockProducto.get(i) == 0) {
                    ListaProductos.remove(i);
                    StockProducto.remove(i);
                }
            } else if (i == ListaProductos.size()) {
                System.out.println("ID no existente...");
                System.out.println("");
            }
        }

    }

//    @Override
//    public void ReponerProductos() {
//        //Genero 3 productos a mano
//
//        Producto producto1 = new Producto(10, 1.7f, "des");
//        Producto producto2 = new Producto(11, 1.6f, "des");
//        Producto producto3 = new Producto(12, 1.0f, "des");
//
//        ListaProductos.add(producto1);
//        ListaProductos.add(producto2);
//        ListaProductos.add(producto3);
//
//    }
}
