package generics.customlistiterator;

import java.util.Collections;
import java.util.List;

public class Sorter<T> {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        Collections.sort(list);
    }
}
