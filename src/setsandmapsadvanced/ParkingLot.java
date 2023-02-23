package setsandmapsadvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] inputArgs = input.split(", ");
            String direction = inputArgs[0];
            String registrationNumber = inputArgs[1];

            if (direction.equals("IN")) {
                parking.add(registrationNumber);
            } else {
                parking.remove(registrationNumber);
            }
            input = sc.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.print(printParking(parking));
        }
    }

    private static String printParking(Set<String> parking) {
        StringBuilder builder = new StringBuilder();
        for (String car : parking) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
