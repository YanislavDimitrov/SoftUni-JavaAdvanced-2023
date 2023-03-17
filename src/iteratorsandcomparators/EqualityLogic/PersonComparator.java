package iteratorsandcomparators.EqualityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().equals(second.getName()) && first.getAge() == second.getAge()) {
            return 0;
        }
        return 1;
    }

}
