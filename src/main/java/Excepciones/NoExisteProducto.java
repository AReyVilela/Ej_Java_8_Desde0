package Excepciones;

public class NoExisteProducto extends  Exception{
    public NoExisteProducto( ){
        super("No existe producto..");
    }
}
