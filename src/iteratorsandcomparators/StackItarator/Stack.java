package iteratorsandcomparators.StackItarator;

import java.util.*;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {
    private List<T> collection;

    public Stack() {
        this.collection = new ArrayList<>();
    }

    public void push(List<T> elements) {
        this.collection.addAll(elements);
    }

    public void pop() {
        if (this.collection.size() == 0) {
            throw new UnsupportedOperationException("No elements");
        }
        this.collection.remove(this.collection.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        while (this.collection.iterator().hasNext()) {
            action.accept(this.collection.iterator().next());
        }
    }

    private class StackIterator implements Iterator<T> {
        int counter = collection.size()-1;

        @Override
        public boolean hasNext() {
            return counter >= 0;
        }

        @Override
        public T next() {
            return collection.get(counter--);
        }
    }
}
