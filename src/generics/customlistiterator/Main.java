package generics.customlistiterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        String input = sc.nextLine();

        while (!input.equals("END")) {
            String[] inputArgs = input.split("\\s+");

            String command = inputArgs[0];

            switch (command) {
                case "Add":
                    list.add(inputArgs[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(inputArgs[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(inputArgs[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(inputArgs[1]), Integer.parseInt(inputArgs[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(inputArgs[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;
                case "Sort":
                    list.sort();
                    break;
            }
            input = sc.nextLine();
        }
    }
}