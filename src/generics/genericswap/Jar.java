package generics.genericswap;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private List<T> items;

    public Jar() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public void swap(int firstIndex, int secondIndex){
        T temp = this.items.get(firstIndex);
        this.items.set(firstIndex,this.items.get(secondIndex));
        this.items.set(secondIndex,temp);
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
