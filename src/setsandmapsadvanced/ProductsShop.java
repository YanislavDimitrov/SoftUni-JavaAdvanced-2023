package setsandmapsadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductsShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = sc.nextLine();

        while (!input.equals("Revision")) {
            String[] inputArgs = input.split(", ");
            String shopName = inputArgs[0];
            String product = inputArgs[1];
            Double price = Double.parseDouble(inputArgs[2]);

            if (!shops.containsKey(shopName)) {
                shops.put(shopName, new LinkedHashMap<>());
            }
            shops.get(shopName).put(product, price);
            input = sc.nextLine();
        }
        System.out.println(printShops(shops));
    }

    private static String printShops(Map<String, Map<String, Double>> shops) {
        StringBuilder builder = new StringBuilder();
        for (String shop : shops.keySet()) {
            builder.append(shop + "->").append(System.lineSeparator());
            for (String product : shops.get(shop).keySet()) {
                builder.append("Product: " + product + ", Price: " + String.format("%.1f", shops.get(shop).get(product))).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
