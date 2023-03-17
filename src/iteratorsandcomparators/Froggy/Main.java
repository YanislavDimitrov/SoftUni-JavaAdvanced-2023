package iteratorsandcomparators.Froggy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        String input = sc.nextLine();
        Lake<Integer> lake = null;

        while (!input.equals("END")) {
            List<Integer> numbers = Arrays.stream(input.split(", ")).map(Integer::parseInt).collect(Collectors.toList());

            lake = new Lake<>(numbers);

            input = sc.nextLine();
        }
        for (Integer integer : lake) {
            result.add(integer);
        }
        System.out.println(String.join(" ", String.valueOf(result)
                .replaceAll("\\[|\\]", "")));

    }
}