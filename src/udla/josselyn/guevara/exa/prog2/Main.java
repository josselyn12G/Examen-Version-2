package udla.josselyn.guevara.exa.prog2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Venta venta = new Venta();
        Ropa ropa = new Ropa();
        Calzado calzado = new Calzado();
        Accesorio accesorio = new Accesorio();
        Vendedor vendedor = new Vendedor();
        Gerente gerente = new Gerente();
        do{
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"1. Agregar Producto\n 2.Mostrar Producto\n 3.Eliminar Productos \n 4.Agregar Empleado\n 5. Eliminar Empleado" +
                    "\n 6.Mostrar Empleados\n 7. Realizar venta.\n 8.Imprimir ventas"));
            switch(opcion){
                case 1:
                    int opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null,"1. Ropa\n 2.Calzado\n 3.Accesorio"));
                    switch (opcion1){
                        case 1:
                            venta.agregarProducto(ropa);
                            break;
                        case 2:
                            venta.agregarProducto(calzado);
                            break;
                        case 3:
                            venta.agregarProducto(accesorio);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    venta.imprimirProductos();
                    break;
                case 3:
                    String codigo = JOptionPane.showInputDialog(null,"Ingrese el código del producto");
                    venta.eliminarProducto(codigo);
                    break;
                case 4:
                    int opcion4 = Integer.parseInt(JOptionPane.showInputDialog(null,"1. Vendedor\n 2.Gerente\n"));
                    switch (opcion4){
                        case 1:
                            venta.agregarEmpleado(vendedor);
                            break;
                        case 2:
                            venta.agregarEmpleado(gerente);
                            break;
                        default:
                            break;
                    }

                    break;
                case 5:
                    String id = JOptionPane.showInputDialog(null,"Ingrese el código del empleado");
                    venta.eliminarEmpleado(id);
                    break;
                case 6:
                    venta.imprimirEmpleados();
                    break;
                case 7:
                    String idProducto = JOptionPane.showInputDialog(null,"Ingrese el código del empleado");
                    venta.registrarVenta(idProducto,vendedor);
                    break;
                case 8:
                    venta.imprimirVentas();
                    break;
                default:
                    break;
            }


        }while(true);
    }
}
