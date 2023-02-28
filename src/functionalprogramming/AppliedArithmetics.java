package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        String input = sc.nextLine();
        Function<Integer, Integer> function;
        while (!input.equals("end")) {

            if (input.equals("print")) {
                printNumbers(numbers);
                input = sc.nextLine();
                continue;
            }
            function = getFunction(input);
            numbers = Arrays.stream(numbers).map(function).toArray(Integer[]::new);

            input = sc.nextLine();
        }
//        printNumbers(numbers);
    }

    private static void printNumbers(Integer[] numbers) {
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static Function<Integer, Integer> getFunction(String input) {
        switch (input) {
            case "add":
                return e -> e + 1;
            case "multiply":
                return e -> e * 2;
            default:
                return e -> e - 1;
        }
    }
}
