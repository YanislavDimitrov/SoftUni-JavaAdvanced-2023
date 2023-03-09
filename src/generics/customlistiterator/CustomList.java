package generics.customlistiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> items;

    public CustomList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public T remove(int index) {
        return this.items.remove(index);
    }

    public boolean contains(T item) {
        return this.items.contains(item);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.items.get(firstIndex);
        this.items.set(firstIndex, this.items.get(secondIndex));
        this.items.set(secondIndex, temp);
    }

    public int countGreaterThan(T comparator) {
        int counter = 0;

        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(comparator) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T max = this.items.get(0);

        for (int i = 1; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(max) > 0) {
                max = this.items.get(i);
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.items.get(0);

        for (int i = 1; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(min) < 0) {
                min = this.items.get(i);
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T item : this.items) {
            builder.append(item).append(System.lineSeparator());
        }
        return builder.toString();
    }

    public void sort() {
        Sorter.sort(this.items);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    private final class ListIterator<T> implements Iterator<T> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if (this.counter < items.size()) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return (T) items.get(counter++);
        }
    }
}

