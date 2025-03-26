package uvg.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for BST functionality.
 */
public class AppTest {

    /**
     * Prueba para verificar la inserción y búsqueda de elementos en el BST.
     */
    @Test
    public void testInsertAndSearch() {
        BST<Producto> bst = new BST<>();
        Producto p1 = new Producto("123", 100, 80, "TV", "Electrónica");
        Producto p2 = new Producto("456", 200, 150, "Laptop", "Computadoras");

        // Insertar productos en el árbol
        bst.insertar(p1);
        bst.insertar(p2);

        // Verificar que los productos se puedan buscar correctamente
        assertEquals(p1, bst.buscar(p1));
        assertEquals(p2, bst.buscar(p2));

        // Verificar que un producto no existente devuelva null
        assertNull(bst.buscar(new Producto("789", 0, 0, "", "")));
    }

    /**
     * Prueba para verificar la búsqueda en un árbol vacío.
     */
    @Test
    public void testSearchInEmptyTree() {
        BST<Producto> bst = new BST<>();

        // Intentar buscar en un árbol vacío debe devolver null
        assertNull(bst.buscar(new Producto("123", 0, 0, "", "")));
    }

    /**
     * Prueba para verificar la inserción de elementos duplicados.
     */
    @Test
    public void testInsertDuplicate() {
        BST<Producto> bst = new BST<>();
        Producto p1 = new Producto("123", 100, 80, "TV", "Electrónica");

        // Insertar el mismo producto dos veces
        bst.insertar(p1);
        bst.insertar(p1);

        // Verificar que el producto se pueda buscar correctamente
        assertEquals(p1, bst.buscar(p1));
    }
}