package clases;

import Interfaces.IProducto;

public class Producto implements IProducto {

  int id;
  float precio;
  String descripcion;
    public Producto() {
    }
    public Producto(int id, float precio, String descripcion) {
        this.id = id;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
