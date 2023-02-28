package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<Integer[], Integer> function = e -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < e.length; i++) {
                if (e[i] < min) {
                    min = e[i];
                }
            }
            return min;
        };
        Integer[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(function.apply(numbers));
    }
}
