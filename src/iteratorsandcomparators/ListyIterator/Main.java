package iteratorsandcomparators.ListyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListyIterator list = null;

        String command = sc.nextLine();

        while (!command.equals("END")) {

            if (command.contains("Create")) {
                String[] items = getItems(command);
                list = new ListyIterator(items);
            } else if (command.equals("Move")) {
                System.out.println(list.move());
            } else if (command.equals("Print")) {
                try {
                    list.print();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid Operation!");
                }
            } else {
                System.out.println(list.hasNext());
            }
            command = sc.nextLine();
        }

    }

    private static String[] getItems(String command) {
        String[] commandArgs = command.split("\\s+");
        String[] result = new String[commandArgs.length - 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = commandArgs[i + 1];
        }
        return result;
    }
}