package uvg.edu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductoAdmin admin = new ProductoAdmin();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        admin.cargarCSV("sku.csv");
        do {
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
                    System.out.println("Productos en orden ascendente:");
                    admin.listarProductosOrdenados(true);
                    break;
                case 3:
                    System.out.println("Productos en orden descendente:");
                    admin.listarProductosOrdenados(false);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}