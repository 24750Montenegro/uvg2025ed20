package uvg.edu;

public interface ILista<T> {
    void add(T item);
    T remove(int index);
    T get(int index);
    boolean isEmpty();
    int size();
}