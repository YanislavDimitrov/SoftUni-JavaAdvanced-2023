package setsandmapsadvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> guestList = new TreeSet<>();

        String input = sc.nextLine();

        while (!input.equals("PARTY")) {
            guestList.add(input);
            input = sc.nextLine();
        }

        input = sc.nextLine();

        while (!input.equals("END")) {
            guestList.remove(input);
            input = sc.nextLine();
        }
        System.out.println(guestList.size());
        for (String guest : guestList) {
            System.out.println(guest);
        }

    }
}
