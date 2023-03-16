package iteratorsandcomparators.BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        if (!first.getTitle().equals(second.getTitle())) {
            return first.getTitle().compareTo(second.getTitle());
        } else {
            return Integer.compare(first.getYear(), second.getYear());
        }
    }
}
