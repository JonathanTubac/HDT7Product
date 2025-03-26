package uvg.edu;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String name;
    private String category;

    public Producto(String sku, double priceRetail, double priceCurrent, String name, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.name = name;
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    @Override
    public int compareTo(Producto other) {
        return this.sku.compareTo(other.sku); // Comparar por SKU
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return Objects.equals(sku, producto.sku); // Comparar solo por SKU
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku); // Generar hash basado en SKU
    }

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