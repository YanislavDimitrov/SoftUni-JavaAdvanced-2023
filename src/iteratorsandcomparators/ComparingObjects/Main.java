package iteratorsandcomparators.ComparingObjects;

import comparingobjects.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] inputArgs = input.split("\\s+");
            String name = inputArgs[0];
            int age = Integer.parseInt(inputArgs[1]);
            String town = inputArgs[2];

            people.add(new Person(name, age, town));

            input = sc.nextLine();
        }
        Person targetPerson = people.get(Integer.parseInt(sc.nextLine()) - 1);
        int matchCount = 0;

        for (Person person : people) {
            if (person.compareTo(targetPerson) == 0) {
                matchCount++;
            }
        }
        if (matchCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", matchCount, people.size() - matchCount, people.size());
        }
    }
}