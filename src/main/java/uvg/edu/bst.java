package uvg.edu;

class Nodo<E> {
    E data;
    Nodo<E> izquierda, derecha;

    public Nodo(E data) {
        this.data = data;
        this.izquierda = this.derecha = null;
    }
}

class BST<E extends Comparable<E>> {
    private Nodo<E> raiz;

    public BST() {
        this.raiz = null;
    }

    public void insertar(E data) {
        raiz = insertarRec(raiz, data);
    }

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

    public E buscar(E data) {
        return buscarRec(raiz, data);
    }

    private E buscarRec(Nodo<E> raiz, E data) {
        if (raiz == null || raiz.data.equals(data)) {
            return raiz != null ? raiz.data : null;
        }
        return data.compareTo(raiz.data) < 0 ? buscarRec(raiz.izquierda, data) : buscarRec(raiz.derecha, data);
    }

    public void inOrdenAscendente() {
        inOrdenAscendenteRec(raiz);
    }

    private void inOrdenAscendenteRec(Nodo<E> raiz) {
        if (raiz != null) {
            inOrdenAscendenteRec(raiz.izquierda);
            System.out.println(raiz.data);
            inOrdenAscendenteRec(raiz.derecha);
        }
    }

    public void inOrdenDescendente() {
        inOrdenDescendenteRecursivo(raiz);
    }
    
    private void inOrdenDescendenteRecursivo(Nodo<E> nodo) {
        if (nodo != null) {
            inOrdenDescendenteRecursivo(nodo.derecha);
            System.out.println(nodo.data);
            inOrdenDescendenteRecursivo(nodo.izquierda);
        }
    }
}
