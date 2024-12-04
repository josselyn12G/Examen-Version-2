package udla.josselyn.guevara.exa.prog2;

abstract public class Empleado {
    // Atributos de la clase Empleado
    private String id;
    private String nombre;
    private double salario;

    // Constructor por defecto
    public Empleado() {
        // Constructor vacío, puede inicializar valores predeterminados si es necesario
    }

    // Constructor con parámetros para inicializar los atributos
    public Empleado(String id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    // Getters y Setters

    // Obtener el ID del empleado
    public String getId() {
        return id;
    }

    // Establecer el ID del empleado
    public void setId(String id) {
        this.id = id;
    }

    // Obtener el nombre del empleado
    public String getNombre() {
        return nombre;
    }

    // Establecer el nombre del empleado
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener el salario del empleado
    public double getSalario() {
        return salario;
    }

    // Establecer el salario del empleado
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    abstract public Empleado agregarEmpleado();  // Metodo para agregar un empleado
    abstract public void imprimirEmpleado();    // Metodo para imprimir la información del empleado
}
