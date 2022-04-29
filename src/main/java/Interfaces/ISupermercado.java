package Interfaces;

import Excepciones.ListaProductosNegativa;

import java.util.HashMap;

public interface ISupermercado {

    public void incrementoStock();

    public  void  decrementoStock();

    public void incrementoCaja();

    public void listarProductos( ) throws ListaProductosNegativa;

    public void mostrarValorCaja();

    public void venderProducto();


}
