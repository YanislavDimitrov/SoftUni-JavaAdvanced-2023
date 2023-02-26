package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int sum = Arrays.stream(numbers)
                .mapToInt(n -> n)
                .sum();

        System.out.printf("Count = %d%n", numbers.length);
        System.out.printf("Sum = %d%n", sum);
    }
}
