/*Programa echo por Jonathan Tubac 24484 
 * Programa que carga datos de un CSV y mediante un BST lo 
 * ordena ascendete o descendentemente*/
package uvg.edu;

import java.util.Objects;

/**
 * Clase que representa un producto con información relevante como SKU, precios, nombre y categoría.
 * Implementa la interfaz Comparable para permitir la comparación entre productos por su SKU.
 */
public class Producto implements Comparable<Producto> {
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String name;
    private String category;

    /**
     * Constructor para inicializar un producto con sus atributos.
     * 
     * @param sku          El identificador único del producto (SKU).
     * @param priceRetail  El precio de venta al por menor del producto.
     * @param priceCurrent El precio actual del producto.
     * @param name         El nombre del producto.
     * @param category     La categoría del producto.
     */
    public Producto(String sku, double priceRetail, double priceCurrent, String name, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.name = name;
        this.category = category;
    }

    /**
     * Obtiene el SKU del producto.
     * 
     * @return El SKU del producto.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Compara este producto con otro producto basado en su SKU.
     * 
     * @param other El otro producto a comparar.
     * @return Un valor negativo, cero o positivo si este producto es menor, igual o mayor que el otro producto.
     */
    @Override
    public int compareTo(Producto other) {
        return this.sku.compareTo(other.sku); // Comparar por SKU
    }

    /**
     * Verifica si este producto es igual a otro objeto.
     * 
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return Objects.equals(sku, producto.sku); // Comparar solo por SKU
    }

    /**
     * Genera un código hash para este producto basado en su SKU.
     * 
     * @return El código hash del producto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sku); // Generar hash basado en SKU
    }

    /**
     * Devuelve una representación en forma de cadena del producto.
     * 
     * @return Una cadena que representa el producto con sus atributos.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "sku='" + sku + '\'' +
                ", priceRetail=" + priceRetail +
                ", priceCurrent=" + priceCurrent +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}