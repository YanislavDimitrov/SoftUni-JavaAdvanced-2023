package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int start = range[0];
        int end = range[1];
        String condition = sc.nextLine();

        Predicate<Integer> predicate = getPredicate(condition);

        IntStream.range(start, end + 1).filter(predicate::test).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static Predicate<Integer> getPredicate(String condition) {

        if (condition.equals("odd")) {
            return e -> e % 2 != 0;
        } else {
            return e -> e % 2 == 0;
        }
    }
}
