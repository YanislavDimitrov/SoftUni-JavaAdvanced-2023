package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] evenNumbers = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter((Integer num) -> num % 2 == 0)
                .toArray(Integer[]::new);

        System.out.println(String.join(" ", Arrays.toString(evenNumbers)
                .replaceAll("\\[|\\]", "")));

        Integer[] sortedEvenNumbers = Arrays.stream(evenNumbers).sorted().toArray(Integer[]::new);

        System.out.println(String.join(" ", Arrays.toString(sortedEvenNumbers)
                .replaceAll("\\[|\\]", "")));
    }
}
