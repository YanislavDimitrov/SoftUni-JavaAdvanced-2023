package iteratorsandcomparators.ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }


    @Override
    public int compareTo(Book other) {
        if (!this.getTitle().equals(other.getTitle())) {
            return this.getTitle().compareTo(other.getTitle());
        } else {
            return Integer.compare(this.getYear(), other.getYear());
        }
    }

    @Override
    public String toString() {
        return "Book " + "\"" +
                this.title + "\"";
    }
}
