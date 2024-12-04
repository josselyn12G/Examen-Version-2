package udla.josselyn.guevara.exa.prog2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

abstract public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private List<Producto> listaProductos = new ArrayList<>();

    // Creacion de constructor
    public Producto(){

    }
    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Creacion de getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // Metodos propios
    abstract public void reducirCantidad(int cantidad);
    abstract public Producto agregarProducto();
    abstract public void imprimirProducto();
    abstract public void mostrarUno();



}