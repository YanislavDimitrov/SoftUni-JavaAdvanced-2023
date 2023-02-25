package setsandmapsadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("report")) {
            String[] inputArgs = input.split("\\|");
            String city = inputArgs[0];
            String country = inputArgs[1];
            long population = Long.parseLong(inputArgs[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new TreeMap<>());
                countries.get(country).put(city, population);
            } else if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, population);
            } else {
                countries.get(country).put(city, countries.get(country).get(city) + population);
            }

            input = sc.nextLine();
        }


        printCountries(countries);
    }

    private static void printCountries(Map<String, Map<String, Long>> countries) {
        countries = countries
                .entrySet()
                .stream()
                .sorted((country1, country2) -> getTotalPopulation(country2.getValue()).compareTo(getTotalPopulation(country1.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> entry : countries.entrySet()) {
            System.out.printf("%s (total population: %d)%n", entry.getKey(), getTotalPopulation(countries.get(entry.getKey())));

            entry.getValue().entrySet().stream().sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                    .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));

        }

    }

    private static Long getTotalPopulation(Map<String, Long> cities) {
        long result = 0;
        for (String city : cities.keySet()) {
            result += cities.get(city);
        }
        return result;
    }
}
