package udla.josselyn.guevara.exa.prog2;

import javax.swing.JOptionPane;

public class Gerente extends Empleado {
    private double bonoAnual;

    // Constructor
    public Gerente(String id, String nombre, double salario, double bonoAnual) {
        super(id, nombre, salario);  // Llamada al constructor de la clase Empleado
        this.bonoAnual = bonoAnual;
    }
    public Gerente(){

    }

    // Getters y setters
    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }

    // Implementación de los métodos abstractos
    @Override
    public Empleado agregarEmpleado() {
        // Usamos JOptionPane para pedir los datos del nuevo gerente
        String id = JOptionPane.showInputDialog("Ingrese el ID del gerente:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del gerente:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del gerente:"));
        double bonoAnual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el bono anual del gerente:"));

        // Retornamos un nuevo objeto Gerente con los datos proporcionados
        return new Gerente(id, nombre, salario, bonoAnual);
    }

    @Override
    public void imprimirEmpleado() {
        // Imprimir la información del gerente con formato
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s \n", "ID", "Nombre", "Salario", "Bono Anual", "Puesto");
        // Imprimir los datos con 2 decimales para salario y bono anual
        System.out.printf("%-10s %-20s %-10.2f %-10.2f %-10s\n", getId(), getNombre(), getSalario(), getBonoAnual(),"Gerente");
    }
}
