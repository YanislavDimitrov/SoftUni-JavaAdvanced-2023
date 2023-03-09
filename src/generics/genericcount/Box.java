package generics.genericcount;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> items;

    public Box() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.items.get(firstIndex);
        this.items.set(firstIndex, this.items.get(secondIndex));
        this.items.set(secondIndex, temp);
    }

    public static <T extends Comparable<T>> int getHigherItemsCount(List<T> items, T comparator) {
        int counter = 0;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).compareTo(comparator) > 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T item : this.items) {
            builder
                    .append(item.getClass().getName())
                    .append(": ")
                    .append(item)
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
