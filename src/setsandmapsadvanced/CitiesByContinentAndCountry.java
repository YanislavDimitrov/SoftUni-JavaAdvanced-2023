package setsandmapsadvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String continent = inputArgs[0];
            String country = inputArgs[1];
            String city = inputArgs[2];

            if (!continents.containsKey(continent)) {
                continents.put(continent, new LinkedHashMap<>());
                continents.get(continent).put(country, new ArrayList<>());
            } else if (!continents.get(continent).containsKey(country)) {
                continents.get(continent).put(country, new ArrayList<>());
            }
            continents.get(continent).get(country).add(city);
        }
        System.out.println(printContinents(continents));
    }

    private static String printContinents(Map<String, Map<String, List<String>>> continents) {
        StringBuilder builder = new StringBuilder();

        for (String continent : continents.keySet()) {
            builder
                    .append(continent)
                    .append(":")
                    .append(System.lineSeparator());

            for (String country : continents.get(continent).keySet()) {
                builder.append(country)
                        .append(" -> ")
                        .append(String.join(", ", continents.get(continent).get(country)))
                        .append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
