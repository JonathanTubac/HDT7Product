/*Programa echo por Jonathan Tubac 24484 
 * Programa que carga datos de un CSV y mediante un BST lo 
 * ordena ascendete o descendentemente*/
package uvg.edu;
import java.io.*;
import java.util.*;

/**
 * Clase que administra los productos utilizando un Árbol Binario de Búsqueda (BST).
 * Permite cargar productos desde un archivo CSV, buscar productos por SKU y listar productos en orden.
 */
class ProductoAdmin {
    private BST<Producto> bst = new BST<>();

    /**
     * Carga los datos de un archivo CSV y los inserta en el Árbol Binario de Búsqueda (BST).
     * 
     * @param rutaArchivo La ruta del archivo CSV que contiene los datos de los productos.
     */
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

    /**
     * Busca un producto en el BST utilizando su SKU.
     * 
     * @param sku El SKU del producto a buscar.
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscarPorSKU(String sku) {
        return bst.buscar(new Producto(sku, 0, 0, "", ""));
    }

    /**
     * Lista los productos almacenados en el BST en orden ascendente o descendente.
     * 
     * @param orden Si es true, los productos se listan en orden ascendente; 
     *              si es false, se listan en orden descendente.
     */
    public void listarProductosOrdenados(boolean orden) {
        if (orden) {
            bst.inOrdenAscendente();
        } else {
            bst.inOrdenDescendente();
        }
    }
}