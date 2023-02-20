package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<String> queue = new ArrayDeque<>();

        String input = sc.nextLine();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.offer(input);
            }
            input = sc.nextLine();
        }
        System.out.println(printQueue(queue));
    }

    private static String printQueue(Deque<String> queue) {
        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            builder.append(queue.poll()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
