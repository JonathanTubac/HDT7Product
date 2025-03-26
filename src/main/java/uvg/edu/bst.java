/*Programa echo por Jonathan Tubac 24484 
 * Programa que carga datos de un CSV y mediante un BST lo 
 * ordena ascendete o descendentemente
 * 
 * Código del árbol basado en:
 * https://www.geeksforgeeks.org/java-program-to-construct-a-binary-search-tree/
*/
package uvg.edu;

/**
 * Clase que representa un nodo en un árbol binario de búsqueda (BST).
 * @param <E> El tipo de dato almacenado en el nodo. Debe implementar Comparable.
 */
class Nodo<E> {
    E data;
    Nodo<E> izquierda, derecha;

    /**
     * Constructor para crear un nodo con un valor específico.
     * @param data El valor a almacenar en el nodo.
     */
    public Nodo(E data) {
        this.data = data;
        this.izquierda = this.derecha = null;
    }
}

/**
 * Clase que implementa un Árbol Binario de Búsqueda (BST).
 * @param <E> El tipo de dato almacenado en el árbol. Debe implementar Comparable.
 */
class BST<E extends Comparable<E>> {
    private Nodo<E> raiz;

    /**
     * Constructor para inicializar un árbol binario de búsqueda vacío.
     */
    public BST() {
        this.raiz = null;
    }

    /**
     * Inserta un nuevo elemento en el árbol.
     * @param data El elemento a insertar.
     */
    public void insertar(E data) {
        raiz = insertarRec(raiz, data);
    }

    /**
     * Método recursivo para insertar un elemento en el árbol.
     * @param raiz El nodo actual.
     * @param data El elemento a insertar.
     * @return El nodo actualizado después de la inserción.
     */
    private Nodo<E> insertarRec(Nodo<E> raiz, E data) {
        if (raiz == null) {
            return new Nodo<>(data);
        }
        if (data.compareTo(raiz.data) < 0) {
            raiz.izquierda = insertarRec(raiz.izquierda, data);
        } else if (data.compareTo(raiz.data) > 0) {
            raiz.derecha = insertarRec(raiz.derecha, data);
        }
        return raiz;
    }

    /**
     * Busca un elemento en el árbol.
     * @param data El elemento a buscar.
     * @return El elemento encontrado o null si no existe.
     */
    public E buscar(E data) {
        return buscarRec(raiz, data);
    }

    /**
     * Método recursivo para buscar un elemento en el árbol.
     * @param raiz El nodo actual.
     * @param data El elemento a buscar.
     * @return El elemento encontrado o null si no existe.
     */
    private E buscarRec(Nodo<E> raiz, E data) {
        if (raiz == null || raiz.data.equals(data)) {
            return raiz != null ? raiz.data : null;
        }
        return data.compareTo(raiz.data) < 0 ? buscarRec(raiz.izquierda, data) : buscarRec(raiz.derecha, data);
    }

    /**
     * Realiza un recorrido inorden ascendente del árbol e imprime los elementos.
     */
    public void inOrdenAscendente() {
        inOrdenAscendenteRec(raiz);
    }

    /**
     * Método recursivo para realizar un recorrido inorden ascendente.
     * @param raiz El nodo actual.
     */
    private void inOrdenAscendenteRec(Nodo<E> raiz) {
        if (raiz != null) {
            inOrdenAscendenteRec(raiz.izquierda);
            System.out.println(raiz.data);
            inOrdenAscendenteRec(raiz.derecha);
        }
    }

    /**
     * Realiza un recorrido inorden descendente del árbol e imprime los elementos.
     */
    public void inOrdenDescendente() {
        inOrdenDescendenteRecursivo(raiz);
    }

    /**
     * Método recursivo para realizar un recorrido inorden descendente.
     * @param nodo El nodo actual.
     */
    private void inOrdenDescendenteRecursivo(Nodo<E> nodo) {
        if (nodo != null) {
            inOrdenDescendenteRecursivo(nodo.derecha);
            System.out.println(nodo.data);
            inOrdenDescendenteRecursivo(nodo.izquierda);
        }
    }
}