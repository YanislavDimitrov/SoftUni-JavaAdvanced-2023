package setsandmapsadvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> resultSet = new LinkedHashSet<>();

        int[] sizes = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < sizes[0]; i++) {
            firstSet.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < sizes[1]; i++) {
            secondSet.add(Integer.parseInt(sc.nextLine()));
        }
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                resultSet.add(integer);
            }
        }
        for (Integer integer : resultSet) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
