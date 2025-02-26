package uvg.edu;

import java.util.Vector;

public class VectorStack<T> extends AbstractStack<T> {
    public VectorStack() {
        stack = new Vector<>();
    }
}