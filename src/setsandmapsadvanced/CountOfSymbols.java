package setsandmapsadvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOfSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Character, Integer> symbols = new TreeMap<>();

        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (!symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, 0);
            }
            symbols.put(currentSymbol, symbols.get(currentSymbol) + 1);
        }
        System.out.println(printSymbols(symbols));
    }

    private static String printSymbols(Map<Character, Integer> symbols) {
        StringBuilder builder = new StringBuilder();

        for (Character symbol : symbols.keySet()) {
            builder.append(symbol)
                    .append(": ")
                    .append(symbols.get(symbol))
                    .append(" time/s")
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
