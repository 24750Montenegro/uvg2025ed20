package uvg.edu;

import java.util.ArrayList;

/**
 * Interfaz genérica para definir operaciones básicas en una pila.
 * @param <T> Tipo de datos que almacenará la pila.
 */
interface Ipila<T> {
    /**
     * Agrega un elemento a la pila.
     * @param item Elemento a agregar.
     */
    void push(T item);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return Elemento eliminado de la cima.
     */
    T pop();

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return Elemento en la cima de la pila.
     */
    T peek();

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    boolean isEmpty();
}
