package iteratorsandcomparators.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private List<T> items;

    public Lake(List<T> items) {
        this.items = new ArrayList<>(items);
    }

    @Override
    public Iterator<T> iterator() {
        return new LakeIterator();
    }

    private class LakeIterator implements Iterator<T> {
        int counter = 0;

        @Override
        public boolean hasNext() {
            if (counter <= items.size() - 1) {
                return true;
            } else {
                if (counter % 2 == 0 && items.size() > 1) {
                    counter = 1;
                    return true;
                } else {
                    return false;
                }
            }
        }

        @Override
        public T next() {
            T current = items.get(counter);
            counter+=2;
            return current;
        }
    }
}
