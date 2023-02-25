package setsandmapsadvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> compounds = new TreeSet<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            compounds.addAll(Arrays.asList(input));
        }

        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
        System.out.println();
    }
}
