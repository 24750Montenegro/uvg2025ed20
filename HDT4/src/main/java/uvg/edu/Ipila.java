package uvg.edu;
import java.util.ArrayList;

interface Ipila<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
