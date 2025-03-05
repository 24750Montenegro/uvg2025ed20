package uvg.edu;

import java.util.ArrayList;

/**
 * Implementación de una pila basada en una lista.
 * @param <T> Tipo de elementos almacenados en la pila.
 */
public class Lista<T> extends AbstractList<T> implements Ipila<T> {
    /**
     * Constructor que inicializa la lista interna.
     */
    public Lista() {
        list = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la pila.
     * @param item Elemento a agregar.
     */
    @Override
    public void push(T item) {
        list.add(item);
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return Elemento eliminado de la cima o null si la pila está vacía.
     */
    @Override
    public T pop() {
        return list.isEmpty() ? null : list.remove(list.size() - 1);
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return Elemento en la cima de la pila o null si la pila está vacía.
     */
    @Override
    public T peek() {
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
