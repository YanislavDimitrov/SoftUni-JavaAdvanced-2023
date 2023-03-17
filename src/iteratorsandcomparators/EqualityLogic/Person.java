package iteratorsandcomparators.EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().equals(other.getName()) && this.getAge() == other.getAge()) {
            return 0;
        }
        if (this.getName().compareTo(other.getName()) != 0) {
            return this.getName().compareTo(other.getName());
        }
        return this.getAge() - other.getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
