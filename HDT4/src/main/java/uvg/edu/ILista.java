package uvg.edu;

/**
 * Interfaz genérica para definir operaciones básicas en una lista.
 * @param <T> Tipo de datos que almacenará la lista.
 */
public interface ILista<T> {
    /**
     * Agrega un elemento a la lista.
     * @param item Elemento a agregar.
     */
    void add(T item);

    /**
     * Elimina un elemento en la posición especificada.
     * @param index Índice del elemento a eliminar.
     * @return Elemento eliminado.
     */
    T remove(int index);

    /**
     * Obtiene el elemento en la posición especificada.
     * @param index Índice del elemento a obtener.
     * @return Elemento en la posición dada.
     */
    T get(int index);

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Devuelve el tamaño actual de la lista.
     * @return Número de elementos en la lista.
     */
    int size();
}
