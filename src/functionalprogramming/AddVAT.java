package functionalprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println("Prices with VAT:");

        Arrays.stream(input.split(", "))
                .map(Double::parseDouble)
                .map(p -> p * 1.2)
                .forEach(p -> System.out.printf("%.2f%n", p));
    }
}
