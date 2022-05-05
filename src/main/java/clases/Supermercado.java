package clases;

import Excepciones.ListaProductosNegativa;
import Excepciones.NoExisteProducto;
import Interfaces.IProducto;

import java.util.*;

public class Supermercado implements Comparator<Producto> {

    ArrayList<IProducto> productos = new ArrayList<>();

    HashMap<Integer, Integer> hashmapCompleto = new HashMap<>();

    float caja = 0.0f;

    public void incrementoStock(Integer id) throws NoExisteProducto {
        IProducto producto = productos.stream().filter(p -> p.getId() == id).findAny().orElse(null);
        if (producto == null) {
           throw new NoExisteProducto();
        } else {
            hashmapCompleto.merge(id, 1, Integer::sum);
        }
    }
    public void setProductos(ArrayList<IProducto> productosRelleno) {
        if(this.productos.isEmpty()){
            this.productos=productosRelleno;
        }
    }
    public void decrementoStock(Integer id) throws NoExisteProducto {
        IProducto producto = productos.stream().filter(p -> p.getId() == id).findAny().orElse(null);
        if (producto != null){
            if(hashmapCompleto.getOrDefault(producto.getId(),0) >0){ // su stock >0
                hashmapCompleto.put(producto.getId(),hashmapCompleto.getOrDefault(producto.getId(),0)-1);
                //pongo en la key id -> el valor que tenia -1
            }else{
                throw new NoExisteProducto();
            }
            System.out.println("Producto vendido !");
        }
    }
    public void incrementoCaja(Integer id) {
        productos.stream().filter(p-> p.getId()== id).findAny().ifPresent(p-> caja += p.getPrecio());
    }
    public void listarProductos() throws ListaProductosNegativa {
        if (productos.isEmpty()) {
            throw new ListaProductosNegativa();
        } else {
            productos.forEach(IProducto -> System.out.println("Id: " + IProducto.getId() + " ->Precio: " + IProducto.getPrecio() + " ->Des: " + IProducto.getDescripcion() + " ->Stock :" + hashmapCompleto.getOrDefault(IProducto.getId(), 0)));
        }
    }
    public void ordenarPorPrecio() {
        productos.stream().sorted().forEach(IProducto -> System.out.println("Id: " + IProducto.getId() + " ->Precio: " + IProducto.getPrecio() + " ->Des: " + IProducto.getDescripcion() + " ->Stock :" + hashmapCompleto.getOrDefault(IProducto.getId(), 0)));

    }
    public void ordendarPorStock() {
        productos.stream().sorted(Comparator.comparing(IProducto -> hashmapCompleto.getOrDefault(IProducto.getId(), 0))).forEach(IProducto -> System.out.println("**Stock :" + hashmapCompleto.getOrDefault(IProducto.getId(), 0) + " ->Id: " + IProducto.getId() + " ->Precio: " + IProducto.getPrecio() + " ->Des: " + IProducto.getDescripcion()));
    }
    public void filtrarProductosporStock(int stockFilter) {

        productos.stream().filter(p -> stockFilter >= hashmapCompleto.getOrDefault(p.getId(), 0)).forEach(IProducto -> System.out.println("Id: " + IProducto.getId() + " ->Precio: " + IProducto.getPrecio() + " ->Des: " + IProducto.getDescripcion() + "  **Stock :" + hashmapCompleto.getOrDefault(IProducto.getId(), 0)));

    }
    public void mostrarValorCaja() {
        System.out.println("Saldo de caja es : " + caja + " €");
        System.out.println("");
    }
    public void venderProducto(int idaEliminar) throws ListaProductosNegativa, NoExisteProducto {
        decrementoStock(idaEliminar);
        incrementoCaja(idaEliminar);
    }
    @Override
    public int compare(Producto producto, Producto t1) {
        return producto.getId() - t1.getId();
    }

}


