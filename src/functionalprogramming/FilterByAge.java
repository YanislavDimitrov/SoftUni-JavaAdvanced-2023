package functionalprogramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split(", ");
            people.put(inputArgs[0], Integer.parseInt(inputArgs[1]));
        }
        String condition = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        Predicate<Integer> predicate = getPredicate(condition, age);
        Consumer<Map.Entry<String, Integer>> consumer = getConsumer(format);

        people.entrySet().stream().filter(entry -> predicate.test(entry.getValue())).forEach(consumer::accept);
    }

    private static Consumer<Map.Entry<String, Integer>> getConsumer(String format) {
        switch (format) {
            case "name":
                return e -> System.out.println(e.getKey());
            case "age":
                return e -> System.out.println(e.getValue());
            default:
                return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
    }

    private static Predicate<Integer> getPredicate(String condition, int age) {
        if (condition.equals("older")) {
            return e -> e >= age;
        } else {
            return e -> e <= age;
        }
    }
}
