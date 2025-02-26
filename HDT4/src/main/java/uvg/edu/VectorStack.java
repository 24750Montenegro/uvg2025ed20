package uvg.edu;

import java.util.Vector;

/**
 * Implementación de una pila basada en la clase Vector.
 * Hereda de AbstractStack para proveer funcionalidad básica de una pila.
 * 
 * @param <T> Tipo de elementos almacenados en la pila.
 */
public class VectorStack<T> extends AbstractStack<T> {
    /**
     * Constructor que inicializa la pila con un Vector vacío.
     */
    public VectorStack() {
        stack = new Vector<>();
    }
}
