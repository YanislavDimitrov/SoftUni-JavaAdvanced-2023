package setsandmapsadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<Integer> firstPlayer = new LinkedHashSet<>(firstPlayerCards);
        Set<Integer> secondPlayer = new LinkedHashSet<>(secondPlayerCards);

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty()||secondPlayer.isEmpty()){
                break;
            }
            int firstPlayerCard = firstPlayer.iterator().next();
            int secondPlayerCard = secondPlayer.iterator().next();
            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
