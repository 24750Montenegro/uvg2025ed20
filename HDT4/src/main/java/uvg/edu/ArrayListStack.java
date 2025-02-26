package uvg.edu;

import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {
    public ArrayListStack() {
        stack = new ArrayList<>();
    }
}