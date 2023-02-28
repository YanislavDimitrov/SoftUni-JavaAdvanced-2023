package functionalprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers);
        int n = Integer.parseInt(sc.nextLine());

        numbers.stream().filter(integer -> integer % n != 0).forEach(integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
