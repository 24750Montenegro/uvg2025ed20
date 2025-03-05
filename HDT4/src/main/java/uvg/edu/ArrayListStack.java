package uvg.edu;

import java.util.ArrayList;

/**
 * Esta clase implementa una pila utilizando una lista de tipo ArrayList.
 * Extiende la clase abstracta {@link AbstractStack} y proporciona
 * la funcionalidad básica de una pila (LIFO) usando una estructura dinámica.
 * 
 * @param <T> El tipo de los elementos almacenados en la pila.
 */
public class ArrayListStack<T> extends AbstractStack<T> {

    /**
     * Constructor que inicializa la pila como un ArrayList vacío.
     */
    public ArrayListStack() {
        stack = new ArrayList<>();
    }
}
