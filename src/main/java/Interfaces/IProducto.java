package Interfaces;

import clases.Producto;

public interface IProducto {

    public  int getId() ;

    public void setId(int id) ;


    public float getPrecio() ;


    public void setPrecio(float precio) ;


    public String getDescripcion() ;


    public void setDescripcion(String descripcion) ;


    int compare(Producto producto, Producto t1);
}
