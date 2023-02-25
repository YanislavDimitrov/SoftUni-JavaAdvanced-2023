package setsandmapsadvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> specialMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        specialMaterials.put("shards", 0);
        specialMaterials.put("fragments", 0);
        specialMaterials.put("motes", 0);

        boolean isObtained = false;
        while (true) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            for (int i = 0; i < inputArgs.length; i += 2) {
                int quantity = Integer.parseInt(inputArgs[i]);
                String material = inputArgs[i + 1].toLowerCase();

                if (specialMaterials.containsKey(material)) {
                    specialMaterials.put(material, specialMaterials.get(material) + quantity);
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, 0);
                    }
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
                if (isItemObtained(specialMaterials)) {
                    System.out.println(printObtainedItem(specialMaterials));
                    isObtained = true;
                    break;
                }
            }
            if (isObtained) {
                break;
            }
        }
        printSpecialMaterials(specialMaterials);
        System.out.println(printJunkMaterials(junkMaterials));
    }

    private static String printJunkMaterials(Map<String, Integer> junkMaterials) {
        StringBuilder builder = new StringBuilder();
        for (String material : junkMaterials.keySet()) {
            builder.append(material)
                    .append(": ")
                    .append(junkMaterials.get(material))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

    private static void printSpecialMaterials(Map<String, Integer> specialMaterials) {
        StringBuilder builder = new StringBuilder();

        specialMaterials.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue())).forEach(element -> {
            builder.append(element.getKey())
                    .append(": ")
                    .append(element.getValue())
                    .append(System.lineSeparator());
        });
        System.out.print(builder);
    }

    private static String printObtainedItem(Map<String, Integer> specialMaterials) {
        String result = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : specialMaterials.entrySet()) {
            if (stringIntegerEntry.getValue() >= 250) {
                specialMaterials.put(stringIntegerEntry.getKey(), specialMaterials.get(stringIntegerEntry.getKey()) - 250);
                switch (stringIntegerEntry.getKey()) {
                    case "shards":
                        result = "Shadowmourne obtained!";
                        break;
                    case "fragments":
                        result = "Valanyr obtained!";
                        break;
                    case "motes":
                        result = "Dragonwrath obtained!";
                        break;
                }
            }
        }
        return result;
    }

    private static boolean isItemObtained(Map<String, Integer> specialMaterials) {
        for (Map.Entry<String, Integer> stringIntegerEntry : specialMaterials.entrySet()) {
            if (stringIntegerEntry.getValue() >= 250) {
                return true;
            }
        }
        return false;
    }
}
