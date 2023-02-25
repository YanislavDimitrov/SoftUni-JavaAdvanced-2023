package setsandmapsadvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String ipAddress = inputArgs[0];
            String name = inputArgs[1];
            int time = Integer.parseInt(inputArgs[2]);

            if (!logs.containsKey(name)) {
                logs.put(name, new TreeMap<>());
                logs.get(name).put(ipAddress, 0);
            } else if (!logs.get(name).containsKey(ipAddress)) {
                logs.get(name).put(ipAddress, 0);
            }
            logs.get(name).put(ipAddress, logs.get(name).get(ipAddress) + time);
        }
        printLogs(logs);
    }

    private static void printLogs(Map<String, Map<String, Integer>> logs) {

        for (Map.Entry<String, Map<String, Integer>> nameEntry : logs.entrySet()) {
            System.out.printf("%s: %d %s%n"
                    , nameEntry.getKey()
                    , getTotalTime(nameEntry.getValue())
                    , nameEntry.getValue().keySet().stream().collect(Collectors.toList()));

        }
    }

    private static int getTotalTime(Map<String, Integer> ipAddresses) {
        int totalTime = 0;

        for (Map.Entry<String, Integer> entry : ipAddresses.entrySet()) {
            totalTime += entry.getValue();
        }
        return totalTime;
    }
}
