package uvg.edu;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Stack;
import java.util.Scanner;

class StackFactory {
    public static <T> Stack<T> getStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist": return new ArrayListStack<>();
            case "vector": return new VectorStack<>();
            default: throw new IllegalArgumentException("Tipo de pila no válido");
        }
    }
}
