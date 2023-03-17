package iteratorsandcomparators.StrategyPatern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() != second.getName().length()) {
            return first.getName().length() > second.getName().length()
                    ? 1
                    : -1;
        } else {
            return Character.compare(
                    Character.toLowerCase(first.getName().charAt(0)),
                    Character.toLowerCase(second.getName().charAt(0)));
        }
    }
}
