package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).sorted((f, s) -> {
            if (f % 2 == 0 && s % 2 == 0) {
                return f.compareTo(s);
            } else if (f % 2 == 0) {
                return -1;
            } else if (s % 2 == 0) {
                return +1;
            } else {
                return f.compareTo(s);
            }
        }).collect(Collectors.toList());

        numbers.forEach(e-> System.out.print(e+" "));
        System.out.println();
    }
}
