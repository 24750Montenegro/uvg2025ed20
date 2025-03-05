package uvg.edu;

/**
 * Factoría para la creación de diferentes implementaciones de pilas.
 * Implementa el patrón Singleton para garantizar una única instancia.
 */
public class StackFactory {
    private static StackFactory instance;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private StackFactory() {}

    /**
     * Obtiene la única instancia de StackFactory.
     * @return Instancia única de StackFactory.
     */
    public static StackFactory getInstance() {
        if (instance == null) {
            instance = new StackFactory();
        }
        return instance;
    }

    /**
     * Devuelve una implementación de pila según el tipo especificado.
     * @param <T> Tipo de los elementos en la pila.
     * @param type Tipo de pila deseada ("arraylist", "vector" o "lista").
     * @return Una instancia de la pila correspondiente.
     * @throws IllegalArgumentException Si el tipo de pila no es válido.
     */
    public <T> Ipila<T> getStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist": return new ArrayListStack<>();
            case "vector": return new VectorStack<>();
            case "lista": return new Lista<>();
            default: throw new IllegalArgumentException("Tipo de pila no válido");
        }
    }
}
