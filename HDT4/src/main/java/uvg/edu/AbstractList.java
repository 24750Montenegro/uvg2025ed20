package uvg.edu;

import java.util.List;

/**
 * Esta clase abstracta proporciona una implementación común para listas.
 * Implementa la interfaz {@link ILista} y define las operaciones básicas
 * sobre una lista, como agregar un elemento, eliminar un elemento por índice,
 * obtener un elemento por índice, verificar si la lista está vacía y obtener
 * el tamaño de la lista.
 * 
 * @param <T> El tipo de los elementos almacenados en la lista.
 */
public abstract class AbstractList<T> implements ILista<T> {

    /**
     * La lista que almacena los elementos.
     */
    protected List<T> list;

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param item El elemento que se va a agregar a la lista.
     */
    @Override
    public void add(T item) {
        list.add(item);
    }

    /**
     * Elimina y retorna el elemento en el índice especificado.
     * 
     * @param index El índice del elemento a eliminar.
     * @return El elemento que fue eliminado de la lista.
     */
    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    /**
     * Retorna el elemento en el índice especificado.
     * 
     * @param index El índice del elemento que se va a obtener.
     * @return El elemento en el índice dado.
     */
    @Override
    public T get(int index) {
        return list.get(index);
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return {@code true} si la lista está vacía, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Retorna el tamaño de la lista.
     * 
     * @return El número de elementos en la lista.
     */
    @Override
    public int size() {
        return list.size();
    }
}
