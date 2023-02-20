package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "";
        Deque<String> stack = new ArrayDeque<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandArgs = sc.nextLine().split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "1":
                    stack.push(text);
                    String textToAppend = commandArgs[1];
                    text += textToAppend;
                    break;
                case "2":
                    stack.push(text);
                    int count = Math.min(text.length(), Integer.parseInt(commandArgs[1]));
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArgs[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }
}
