package iteratorsandcomparators.EqualityLogic;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Set<Person> peopleSortedByName = new TreeSet<>();
        Set<Person> peopleSortedByAge = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");

            Person currPerson = new Person(inputArgs[0], Integer.parseInt(inputArgs[1]));
            peopleSortedByName.add(currPerson);
            peopleSortedByAge.add(currPerson);
        }
        System.out.println(peopleSortedByName.size());
        System.out.println(peopleSortedByAge.size());
    }
}