package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetLength = Integer.parseInt(sc.nextLine());

        String[] names = sc.nextLine().split("\\s+");

        Predicate<String> predicate = n -> n.length() <= targetLength;

        Arrays.stream(names).filter(predicate).forEach(e -> System.out.println(e));
    }
}
