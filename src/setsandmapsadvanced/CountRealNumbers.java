package setsandmapsadvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, 0);
            }
            map.put(number, map.get(number) + 1);
        }
        for (Double number : map.keySet()) {
            System.out.printf("%.1f -> %d%n",number,map.get(number));
        }
    }
}
