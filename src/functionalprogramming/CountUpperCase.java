package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> capitalWords = Arrays.stream(sc.nextLine().split(" "))
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(w -> System.out.println(w));
    }
}
