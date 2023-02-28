package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> function = e -> {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < e.size(); i++) {
                if (e.get(i) <= minValue) {
                    minValue = e.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };
        int bestIndex = function.apply(numbers);
        System.out.println(bestIndex);
    }
}
