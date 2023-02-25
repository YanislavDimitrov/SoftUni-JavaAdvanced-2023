package setsandmapsadvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> userNames = new LinkedHashSet<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            userNames.add(input);
        }
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}
