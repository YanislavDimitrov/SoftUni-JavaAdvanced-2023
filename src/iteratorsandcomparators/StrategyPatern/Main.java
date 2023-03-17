package iteratorsandcomparators.StrategyPatern;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Set<Person> peopleSortedByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleSortedByAge = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            Person currentPerson = new Person(inputArgs[0], Integer.parseInt(inputArgs[1]));
            peopleSortedByName.add(currentPerson);
            peopleSortedByAge.add(currentPerson);
        }
        for (Person person : peopleSortedByName) {
            System.out.println(person.getName() + " " + person.getAge());
        }
        for (Person person : peopleSortedByAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}