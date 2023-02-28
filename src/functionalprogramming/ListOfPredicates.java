package functionalprogramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Set<Integer> dividors = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));

        List<Predicate<Integer>> predicates = new ArrayList<>();
        populatePredicates(dividors, predicates);
        Integer[] numbers = IntStream.range(1, n + 1)
                .boxed()
                .toArray(Integer[]::new);

        for (int i = 0; i < predicates.size(); i++) {
            numbers = Arrays.stream(numbers).filter(predicates.get(i)).toArray(Integer[]::new);
        }
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }

    private static void populatePredicates(Set<Integer> dividors, List<Predicate<Integer>> predicates) {
        Predicate<Integer> current;
        for (Integer dividor : dividors) {
            current = e -> e % dividor == 0;
            predicates.add(current);
        }
    }
}
