package uvg.edu;

import java.util.List;

/**
 * Esta clase abstracta proporciona una implementación común para pilas.
 * Implementa la interfaz {@link Ipila} y define las operaciones básicas de
 * una pila, como agregar un elemento, eliminar el elemento superior,
 * obtener el elemento superior sin eliminarlo y verificar si la pila está vacía.
 * 
 * @param <T> El tipo de los elementos almacenados en la pila.
 */
public abstract class AbstractStack<T> implements Ipila<T> {

    /**
     * La lista que almacena los elementos de la pila.
     */
    protected List<T> stack;

    /**
     * Agrega un elemento al final de la pila.
     * 
     * @param item El elemento que se va a agregar a la pila.
     */
    @Override
    public void push(T item) {
        stack.add(item);
    }

    /**
     * Elimina y retorna el elemento superior de la pila.
     * Si la pila está vacía, retorna {@code null}.
     * 
     * @return El elemento superior de la pila o {@code null} si la pila está vacía.
     */
    @Override
    public T pop() {
        return stack.isEmpty() ? null : stack.remove(stack.size() - 1);
    }

    /**
     * Retorna el elemento superior de la pila sin eliminarlo.
     * Si la pila está vacía, retorna {@code null}.
     * 
     * @return El elemento superior de la pila o {@code null} si la pila está vacía.
     */
    @Override
    public T peek() {
        return stack.isEmpty() ? null : stack.get(stack.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
