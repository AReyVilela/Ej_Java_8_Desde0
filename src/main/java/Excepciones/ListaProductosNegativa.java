package Excepciones;

import java.util.HashMap;

public class ListaProductosNegativa extends Exception{
    public ListaProductosNegativa ( ){
        super("Lista de productos con valor negativo..");
    }
}
