package uvg.edu;

import java.util.List;

public abstract class AbstractStack<T> implements Ipila<T> {
    protected List<T> stack;

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        return stack.isEmpty() ? null : stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        return stack.isEmpty() ? null : stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}