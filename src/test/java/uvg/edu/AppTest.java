package uvg.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    void testInsertAndSearch() {
        BST<Producto> bst = new BST<>();
        Producto p1 = new Producto("123", 100, 80, "TV", "Electrónica");
        Producto p2 = new Producto("456", 200, 150, "Laptop", "Computadoras");

        bst.insertar(p1);
        bst.insertar(p2);

        assertEquals(p1, bst.buscar(p1));
        assertEquals(p2, bst.buscar(p2));
        assertNull(bst.buscar(new Producto("789", 0, 0, "", "")));
    }
}
