package udla.josselyn.guevara.exa.prog2;

import javax.swing.*;

public class Accesorio extends Producto {
    private String tipo;
    // Constructor
    public Accesorio(){

    }
    public Accesorio(String codigo, String nombre, double precio, int cantidad, String tipo) {
        super(codigo, nombre, precio, cantidad);
        this.tipo = tipo;
    }


    // Getters y setters


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    // Metodos propios
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
    public Accesorio agregarProducto() {
        String codigo = JOptionPane.showInputDialog(null,"Codigo del producto");
        String nombre = JOptionPane.showInputDialog(null,"Nombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Precio del producto"));
        String tipo = JOptionPane.showInputDialog(null,"Tipo de accesorio");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad del producto"));
        return new Accesorio(codigo,nombre,precio,cantidad,tipo);
    }
    @Override
    public void imprimirProducto() {
        // Encabezado de la tabla
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s |\n", "Código", "Nombre", "Precio", "Tipo", "Cantidad");
        System.out.println("--------------------------------------------------------------------------------------------------");
        // Fila de datos
        System.out.printf("| %-10s | %-20s | %-10.2f | %-10s | %-10d |\n",
                getCodigo(), getNombre(), getPrecio(), getTipo(), getCantidad());
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
                        "Tipo: %s",
                getCodigo(), getNombre(), getPrecio(), getCantidad(), getTipo()
        );
        JOptionPane.showMessageDialog(null, mensaje);
    }


}
