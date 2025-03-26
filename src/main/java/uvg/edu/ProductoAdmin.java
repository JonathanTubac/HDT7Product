package uvg.edu;
import java.io.*;
import java.util.*;

class ProductoAdmin {
    private BST<Producto> bst = new BST<>();

    public void cargarCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/uvg/edu/sku.csv"))) {
            String linea;
            br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 19) {
                    String category = datos[0].trim();
                    String sku = datos[6].trim();
                    double priceRetail = Double.parseDouble(datos[9].trim().isEmpty() ? "0" : datos[9].trim());
                    double priceCurrent = Double.parseDouble(datos[10].trim().isEmpty() ? "0" : datos[10].trim());
                    String name = datos[18].trim();

                    Producto producto = new Producto(sku, priceRetail, priceCurrent, name, category);
                    bst.insertar(producto);
                }
            }
            System.out.println("Datos cargados...");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    public Producto buscarPorSKU(String sku) {
        return bst.buscar(new Producto(sku, 0, 0, "", ""));
    }

    public void listarProductosOrdenados(boolean orden) {
        if (orden) {
            bst.inOrdenAscendente();
        } else {
            bst.inOrdenDescendente();
        }
    }
}
