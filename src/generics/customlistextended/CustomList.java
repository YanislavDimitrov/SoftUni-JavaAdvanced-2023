package generics.customlistextended;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
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
}
