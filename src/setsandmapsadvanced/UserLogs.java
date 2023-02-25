package setsandmapsadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String input = sc.nextLine();

        while (!input.equals("end")) {
            String[] inputArgs = input.split("\\s");
            String ipAddress = getIpAddress(inputArgs);
            String userName = getUsername(inputArgs);

            if (!users.containsKey(userName)) {
                users.put(userName, new LinkedHashMap<>());
                users.get(userName).put(ipAddress, 0);
            } else if (!users.get(userName).containsKey(ipAddress)) {
                users.get(userName).put(ipAddress, 0);
            }
            users.get(userName).put(ipAddress, users.get(userName).get(ipAddress) + 1);

            input = sc.nextLine();
        }
        System.out.println(printUsers(users));
    }

    private static String printUsers(Map<String, Map<String, Integer>> users) {
        StringBuilder builder = new StringBuilder();

        for (String user : users.keySet()) {
            builder.append(user)
                    .append(":")
                    .append(System.lineSeparator());

            int counter = users.get(user).size();
            for (String ipAddress : users.get(user).keySet()) {

                builder.append(ipAddress)
                        .append(" => ")
                        .append(users.get(user).get(ipAddress));

                if (counter-- > 1) {
                    builder.append(", ");
                } else {
                    builder.append(".");
                }
            }
            builder.append(System.lineSeparator());
        }


        return builder.toString();
    }

    private static String getUsername(String[] inputArgs) {
        String[] userNameArgs = inputArgs[2].split("=");
        return userNameArgs[1];
    }

    private static String getIpAddress(String[] inputArgs) {
        String[] ipArgs = inputArgs[0].split("=");
        return ipArgs[1];
    }
}
