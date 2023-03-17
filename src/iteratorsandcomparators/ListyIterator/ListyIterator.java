package iteratorsandcomparators.ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> items;
    private int index;

    public ListyIterator(String... items) {
        this.setItems(items);
        this.index = 0;
    }

    public boolean move() {
        if (this.index == items.size() - 1) {
            return false;
        }
        this.index++;
        return true;
    }

    public void print() {
        System.out.println(items.get(this.index));
    }

    public boolean hasNext() {
        if (this.index == items.size() - 1) {
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
}
