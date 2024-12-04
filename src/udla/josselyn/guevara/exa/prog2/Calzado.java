package udla.josselyn.guevara.exa.prog2;

import javax.swing.*;

public class Calzado extends Producto{
    private int numero;
    // Constructor
    public Calzado(){

    }

    public Calzado(String codigo, String nombre, double precio, int cantidad, int numero) {
        super(codigo, nombre, precio, cantidad);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    public Calzado agregarProducto() {
        String codigo = JOptionPane.showInputDialog(null,"Codigo del producto");
        String nombre = JOptionPane.showInputDialog(null,"Nombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Precio del producto"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero del zapato"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad del producto"));
        return new Calzado(codigo,nombre,precio,cantidad,numero);
    }
    @Override
    public void imprimirProducto() {
        // Imprime el encabezado de la tabla
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s |\n", "Código", "Nombre", "Precio", "Número", "Cantidad");
        System.out.println("--------------------------------------------------------------------------------------------------");

        // Imprime los datos del producto
        System.out.printf("| %-10s | %-20s | %-10.2f | %-10d | %-10d |\n",
                getCodigo(), getNombre(), getPrecio(), getNumero(), getCantidad());
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
                        "Número: %d",
                getCodigo(), getNombre(), getPrecio(), getCantidad(), getNumero()
        );
        JOptionPane.showMessageDialog(null, mensaje);
    }


}
