package definingclasses.opinionpoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            people.add(new Person(inputArgs[0], Integer.parseInt(inputArgs[1])));
        }
        people.stream().filter(per -> per.getAge() > 30).sorted((l,r)->l.getName().compareTo(r.getName())).forEach(person -> System.out.println(person));
    }
}