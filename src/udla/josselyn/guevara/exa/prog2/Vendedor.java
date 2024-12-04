package udla.josselyn.guevara.exa.prog2;

import javax.swing.*;

public class Vendedor extends Empleado {
    private double comision;

    // Constructor
    public Vendedor(String id, String nombre, double salario, double comision) {
        super(id, nombre, salario);
        this.comision = comision;
    }
    public Vendedor(){

    }

    // Getters y setters
    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public Empleado agregarEmpleado() {
        // Solicitar datos mediante JOptionPane
        String id = JOptionPane.showInputDialog(null, "ID del empleado");
        String nombre = JOptionPane.showInputDialog(null, "Nombre del empleado");
        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario del empleado"));
        double comision = Double.parseDouble(JOptionPane.showInputDialog(null, "Comisión del empleado"));

        // Crear un nuevo objeto Vendedor con los datos proporcionados
        return new Vendedor(id, nombre, salario, comision);
    }

    @Override
    public void imprimirEmpleado() {
        // Imprimir la información del vendedor con formato
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s  \n", "ID", "Nombre", "Salario", "Comisión", "Puesto");
        // Aquí especificamos que los números decimales se muestren con 2 decimales para mejor presentación
        System.out.printf("%-10s %-20s %-10.2f %-10.2f %-10s\n", getId(), getNombre(), getSalario(), getComision(), "Vendedor");
    }
}
