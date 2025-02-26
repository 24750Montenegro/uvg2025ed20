package uvg.edu;
import java.util.ArrayList;

interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
