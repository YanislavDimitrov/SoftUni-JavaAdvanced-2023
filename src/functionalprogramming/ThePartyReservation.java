package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> filteredGuests = new ArrayList<>();

        String input = sc.nextLine();

        while (!input.equals("Print")) {
            String[] inputArgs = input.split(";");

            Predicate<String> currentPredicate = getPredicate(inputArgs);

            if (inputArgs[0].equals("Remove filter")) {
//                guests = guests.stream().filter(currentPredicate).collect(Collectors.toList());
                List<String> filtersToAdd = filteredGuests.stream().filter(currentPredicate.negate()).collect(Collectors.toList());
                filtersToAdd.addAll(guests);
                guests = new ArrayList<>(filtersToAdd);
                filteredGuests = filteredGuests.stream().filter(currentPredicate).collect(Collectors.toList());
            } else {
                filteredGuests.addAll(guests.stream().filter(currentPredicate).collect(Collectors.toList()));
                guests = guests.stream().filter(currentPredicate.negate()).collect(Collectors.toList());
            }

            input = sc.nextLine();
        }
        System.out.println(String.join(" ", guests));

    }

    private static Predicate<String> getPredicate(String[] inputArgs) {
        String command = inputArgs[0];
        String condition = inputArgs[1];
        String conditionArgument = inputArgs[2];

        switch (condition) {
            case "Starts with":
                if (command.equals("Remove filter")) {
                    return e -> e.indexOf(conditionArgument) != 0;
                } else {
                    return e -> e.indexOf(conditionArgument) == 0;
                }
            case "Ends with":
                if (command.equals("Remove filter")) {
                    return e -> e.lastIndexOf(conditionArgument) != e.length() - conditionArgument.length();
                } else {
                    return e -> e.lastIndexOf(conditionArgument) == e.length() - conditionArgument.length();
                }
            case "Length":
                if (command.equals("Remove filter")) {
                    return e -> e.length() != Integer.parseInt(conditionArgument);
                } else {
                    return e -> e.length() == Integer.parseInt(conditionArgument);
                }
            default:
                if (command.equals("Remove filter")) {
                    return e -> !e.contains(conditionArgument);
                } else {
                    return e -> e.contains(conditionArgument);
                }
        }
    }
}
