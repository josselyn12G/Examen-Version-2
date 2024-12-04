package udla.josselyn.guevara.exa.prog2;

import javax.swing.*;
import java.util.List;

public class Ropa extends Producto{
    private String talla;

    // COnstructor
    public Ropa(){

    }

    public Ropa(String codigo, String nombre, double precio, int cantidad, String talla) {
        super(codigo, nombre, precio, cantidad);
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    // Implementacion del metodo abstracto

    @Override
    public void reducirCantidad(int cantidad) {
        if (cantidad <= getCantidad()) {
            setCantidad(getCantidad() - cantidad);
            JOptionPane.showMessageDialog(null,
                    String.format("Venta exitosa. Stock actualizado: %d unidades restantes.", getCantidad()));
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cantidad insuficiente en stock. No se puede completar la venta.");
        }
    }

    @Override
    public Ropa agregarProducto() {
        String codigo = JOptionPane.showInputDialog(null,"Codigo del producto");
        String nombre = JOptionPane.showInputDialog(null,"Nombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Precio del producto"));
        String talla = JOptionPane.showInputDialog(null,"Talla del producto");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad del producto"));
        return new Ropa(codigo,nombre,precio,cantidad,talla);
    }

    @Override
    public void imprimirProducto() {
        // Imprime el encabezado de la tabla
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s |\n", "Código", "Nombre", "Precio", "Talla", "Cantidad");
        System.out.println("--------------------------------------------------------------------------------------------------");

        // Imprime los datos del producto
        System.out.printf("| %-10s | %-20s | %-10.2f | %-10s | %-10d |\n",
                getCodigo(), getNombre(), getPrecio(), getTalla(), getCantidad());
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
    @Override
    public void mostrarUno() {
        String mensaje = String.format(
                "Producto Encontrado:\n" +
                        "Código: %s\n" +
                        "Nombre: %s\n" +
                        "Precio: %.2f\n" +
                        "Cantidad: %d\n" +
                        "Talla: %s",
                getCodigo(), getNombre(), getPrecio(), getCantidad(), getTalla()
        );
        JOptionPane.showMessageDialog(null, mensaje);
    }

}