package functionalprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("Party!")) {
            String[] inputArgs = input.split("\\s+");

            Predicate<String> currentPredicate = getPredicate(inputArgs);

            if (inputArgs[0].equals("Remove")) {
                guests = guests.stream().filter(currentPredicate).collect(Collectors.toList());
            } else {
                guests.addAll(guests.stream().filter(currentPredicate).collect(Collectors.toList()));
            }

            input = sc.nextLine();
        }
        Collections.sort(guests);
        if (guests.size() > 0) {
            System.out.printf("%s are going to the party!", String.join(", ", guests));
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }

    private static Predicate<String> getPredicate(String[] inputArgs) {
        String command = inputArgs[0];
        String condition = inputArgs[1];
        String conditionArgument = inputArgs[2];

        switch (condition) {
            case "StartsWith":
                if (command.equals("Remove")) {
                    return e -> e.indexOf(conditionArgument) != 0;
                } else {
                    return e -> e.indexOf(conditionArgument) == 0;
                }
            case "EndsWith":
                if (command.equals("Remove")) {
                    return e -> e.lastIndexOf(conditionArgument) != e.length() - conditionArgument.length();
                } else {
                    return e -> e.lastIndexOf(conditionArgument) == e.length() - conditionArgument.length();
                }
            default:
                if (command.equals("Remove")) {
                    return e -> e.length() != Integer.parseInt(conditionArgument);
                } else {
                    return e -> e.length() == Integer.parseInt(conditionArgument);
                }
        }
    }
}
