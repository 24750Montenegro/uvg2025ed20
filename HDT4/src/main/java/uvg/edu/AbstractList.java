package uvg.edu;

import java.util.List;

public abstract class AbstractList<T> implements ILista<T> {
    protected List<T> list;

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}