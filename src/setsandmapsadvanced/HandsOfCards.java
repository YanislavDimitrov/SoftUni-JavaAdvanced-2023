package setsandmapsadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static String[] powers;
    public static String[] types;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();
        powers = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        types = new String[]{"", "C", "D", "H", "S"};

        String input = sc.nextLine();

        while (!input.equals("JOKER")) {
            String[] inputArgs = input.split(": ");

            String name = inputArgs[0];
            List<String> cards = Arrays.stream(inputArgs[1].split(", ")).collect(Collectors.toList());

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            players.get(name).addAll(cards);
            input = sc.nextLine();
        }

        for (String player : players.keySet()) {
            System.out.printf("%s: %d%n", player, getValue(players.get(player)));
        }

    }

    private static int getValue(Set<String> cards) {
        int result = 0;
        for (String card : cards) {
            String power = String.valueOf(card.substring(0, card.length()-1));
            String type = String.valueOf(card.charAt(card.length()-1));

            result += (Arrays.asList(powers).indexOf(power) * Arrays.asList(types).indexOf(type));

        }
        return result;
    }
}
