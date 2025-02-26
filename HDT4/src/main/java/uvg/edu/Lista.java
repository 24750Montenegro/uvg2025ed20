package uvg.edu;

import java.util.ArrayList;

public class Lista<T> extends AbstractList<T> implements Ipila<T> {
    public Lista() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.isEmpty() ? null : list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
