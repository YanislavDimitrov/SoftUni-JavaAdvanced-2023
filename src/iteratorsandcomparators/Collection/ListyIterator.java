package iteratorsandcomparators.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> items;
    private int index;

    public ListyIterator(String... items) {
        this.setItems(items);
        this.index = 0;
    }

    public boolean move() {
        if (this.index >= items.size() - 1) {
            return false;
        }
        this.index++;
        return true;
    }

    public void print() {
        System.out.println(this.items.get(this.index));
    }

    public boolean hasNext() {
        if (this.index >= items.size() - 1) {
            return false;
        }
        return true;
    }

    public void setItems(String... items) {
        if (items.length == 0) {
            this.items = new ArrayList<>();
        } else {
            this.items = new ArrayList<>(Arrays.asList(items));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIter();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        while (this.items.iterator().hasNext()) {
            action.accept(this.items.iterator().next());
        }
    }

    public void printAll() {
        System.out.println(String.join(" ", this.items));
    }

    private final class ListyIter implements Iterator<String> {
        int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < items.size() - 1;
        }

        @Override
        public String next() {
            return items.get(counter++);
        }
    }
}
