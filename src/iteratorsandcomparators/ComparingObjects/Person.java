package iteratorsandcomparators.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().compareTo(other.getName()) != 0) {
            return this.getName().compareTo(other.getName());
        } else if (this.getAge() != other.getAge()) {
            return Integer.compare(this.getAge(), other.getAge());
        } else {
            return this.getTown().compareTo(other.getTown());
        }
    }
}
