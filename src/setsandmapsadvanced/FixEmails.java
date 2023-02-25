package setsandmapsadvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> contacts = new LinkedHashMap<>();
        String[] bannedDomains = new String[]{".us", ".uk", ".com"};


        String name = sc.nextLine();

        while (!name.equals("stop")) {
            String email = sc.nextLine();

            if (!Arrays.asList(bannedDomains)
                    .contains(email.substring(email.lastIndexOf(".")).toLowerCase())) {
                contacts.put(name, email);
            }
            name = sc.nextLine();
        }
        for (String contact : contacts.keySet()) {
            System.out.printf("%s -> %s%n", contact, contacts.get(contact));
        }
    }
}
