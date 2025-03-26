/*Programa echo por Jonathan Tubac 24484 
 * Programa que carga datos de un CSV y mediante un BST lo 
 * ordena ascendete o descendentemente*/
package uvg.edu;
import java.util.Scanner;

/**
 * Clase principal que contiene el punto de entrada del programa.
 * Permite interactuar con un sistema de administración de productos
 * utilizando un Árbol Binario de Búsqueda (BST).
 */
public class Main {

    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        ProductoAdmin admin = new ProductoAdmin();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        admin.cargarCSV("sku.csv"); // Carga los datos del archivo CSV en el sistema

        do {
            // Mostrar el menú de opciones
            System.out.println("Menú:");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos en orden ascendente");
            System.out.println("3. Listar productos en orden descendente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Buscar un producto por su SKU
                    System.out.print("Ingrese el SKU del producto: ");
                    String sku = scanner.nextLine();
                    Producto producto = admin.buscarPorSKU(sku);
                    if (producto != null) {
                        System.out.println("Producto encontrado: " + producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 2:
                    // Listar productos en orden ascendente
                    System.out.println("Productos en orden ascendente:");
                    admin.listarProductosOrdenados(true);
                    break;
                case 3:
                    // Listar productos en orden descendente
                    System.out.println("Productos en orden descendente:");
                    admin.listarProductosOrdenados(false);
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    // Manejar opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close(); // Cerrar el escáner al finalizar
    }
}