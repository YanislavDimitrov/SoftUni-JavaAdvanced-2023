package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<String> queue = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        int n = Integer.parseInt(sc.nextLine());

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.printf("Removed %s%n", queue.poll());


        }
        System.out.printf("Last is %s", queue.poll());
    }
}
