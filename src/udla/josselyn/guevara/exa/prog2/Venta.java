package udla.josselyn.guevara.exa.prog2;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class Venta {
    // Declaración de atributos
    private String id;
    private String fecha;
    private Empleado empleado;
    private double total;
    private int cantidadVendida;
    private List<Producto> productosVendidos = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private List<Empleado> listaEmpleados = new ArrayList<>();
    // Creacion de constructor
    public Venta(){

    }

    // Creacion de getters y setters

    public double getTotal() {
        return total;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getTotal(int cantidad, double precio) {

        return total;
    }

    public void setTotal(int cantidad, double precio) {
        this.total = cantidad * precio;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    // Metodos propios
    public void agregarProducto(Producto prenda){
        productosVendidos.add(prenda.agregarProducto());
    }

    public void imprimirProductos() {
        if (productosVendidos.isEmpty()) {
            System.out.println("No hay productos en la venta.");
        } else {
            System.out.println("-------------------------------------LISTA DE PRODUCTOS------------------------------------------------------");
            for (Producto producto : productosVendidos) {
                producto.imprimirProducto();
                // Llama al metodo específico de cada tipo
            }
        }
    }

    public void eliminarProducto(String codigo){
        for(Producto p1: productosVendidos){
            if(p1.getCodigo().equals(codigo)){
                JOptionPane.showMessageDialog(null,"Encontrado y eliminado!");
                productosVendidos.remove(p1);
                break;
            }
        }
    }
    // Metodo para agregar a la lista de empleados
    public void agregarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado.agregarEmpleado());
    }
    // Metodo para imprimir la lista de empleados
    public void imprimirEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados en la lista.");
        } else {
            System.out.println("----------------------- LISTA DE EMPLEADOS------------------------------------------------------------------");
            for (Empleado empleado : listaEmpleados) {
                empleado.imprimirEmpleado();  // Llama al metodo específico de cada tipo de empleado
            }
        }
    }

    // Metodo para eliminar un empleado por ID
    public void eliminarEmpleado(String id) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Empleado encontrado y eliminado.");
                listaEmpleados.remove(emp);
                break;  // Sale del ciclo después de eliminar al empleado
            }
        }
    }


    public void registrarVenta(String codigoEmpleado, Empleado vendedor) {
        // Verificar si el empleado existe
        boolean encontrado = false;
        Empleado empleadoseleccionado = null;
        for(Empleado empleado1: listaEmpleados){
            if(empleado1.getId().equals(codigoEmpleado)){
                encontrado = true;
                empleadoseleccionado = empleado1;
                break;
            }
        }
        if(encontrado == false){
            JOptionPane.showMessageDialog(null,"Empleado no encontrado!");
            return;
        }
        // Pedir al usuario que ingrese el código del producto
        String codigoProducto = JOptionPane.showInputDialog(null, "Ingrese el código del producto a vender:");
        // Buscar el producto en la lista
        Producto productoEncontrado = null;
        for (Producto p1 : productosVendidos) {
            if (p1.getCodigo().equals(codigoProducto)) {
                productoEncontrado = p1;
                break;
            }
        }
        // Verificar si el producto existe
        if (productoEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado. Verifique el código e intente nuevamente.");
            return;
        }
        // Mostrar información del producto encontrado
        productoEncontrado.mostrarUno();
        // Reducir la cantidad del producto
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de venta:"));
        productoEncontrado.reducirCantidad(cantidad);
        // Crear una nueva venta con los datos
        Venta nuevaVenta = new Venta();
        nuevaVenta.setId("VENTA-" + (ventas.size() + 1)); // Generar un ID único
        nuevaVenta.setFecha(java.time.LocalDate.now().toString()); // Fecha actual
        nuevaVenta.setEmpleado(empleadoseleccionado); // Asociar al empleado
        nuevaVenta.setTotal(cantidad, productoEncontrado.getPrecio());
        nuevaVenta.setCantidadVendida(cantidad);
        nuevaVenta.getProductosVendidos().add(productoEncontrado); // Agregar el producto vendido
        // Agregar la venta a la lista de ventas
        ventas.add(nuevaVenta);
        JOptionPane.showMessageDialog(null,
                String.format("Venta registrada con éxito.\nID de Venta: %s\nTotal: %.2f\n", nuevaVenta.getId(), nuevaVenta.getTotal()));
    }

    public void imprimirVentas() {
        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas.");
        } else {
            System.out.println("-----------------------------LISTA DE VENTAS------------------------------------------------------------");
            // Encabezado de la tabla
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.printf("%-15s %-15s %-20s %-15s %-12s %-10s\n",
                    "ID de Venta", "Fecha", "Empleado", "Producto", "Cantidad", "Total");
            System.out.println("---------------------------------------------------------------------------------------------------------");

            // Recorrer todas las ventas y mostrar los detalles
            for (Venta venta : ventas) {
                // Mostrar información de la venta
                System.out.printf("%-15s %-15s %-20s ", venta.getId(), venta.getFecha(),
                        venta.getEmpleado().getNombre() + " (ID: " + venta.getEmpleado().getId() + ")");

                // Mostrar productos vendidos
                for (Producto producto : venta.getProductosVendidos()) {
                    // Imprimir los detalles del producto
                    System.out.printf("%-15s %-12d %.2f\n",
                            producto.getNombre(), venta.getCantidadVendida(),
                            venta.getTotal());
                }

                // Mostrar el total de la venta
                System.out.println("---------------------------------------------------------------------------------------------------------");
            }
        }
    }





}
