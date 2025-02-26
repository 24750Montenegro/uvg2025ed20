package uvg.edu;

public class StackFactory {
    private static StackFactory instance;

    private StackFactory() {}

    public static StackFactory getInstance() {
        if (instance == null) {
            instance = new StackFactory();
        }
        return instance;
    }

    public <T> Ipila<T> getStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist": return new ArrayListStack<>();
            case "vector": return new VectorStack<>();
            case "lista": return new Lista<>();
            default: throw new IllegalArgumentException("Tipo de pila no válido");
        }
    }
}